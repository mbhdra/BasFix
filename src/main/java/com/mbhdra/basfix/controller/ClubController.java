package com.mbhdra.basfix.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.mbhdra.basfix.model.Club;
import com.mbhdra.basfix.service.ClubService;

@Controller
public class ClubController {
	
	@Autowired
	ClubService clubService;
	
	@RequestMapping("addClubPage")
	public String openAddclubPage() {
		
		return "addClubPage";
		
	}
	
	// Add new club to the system
	@RequestMapping(value="addClub", method=RequestMethod.POST)
	public RedirectView addclubPost (Club club, RedirectAttributes ra) {

		RedirectView rv = new RedirectView("addClub", true);
		clubService.addClub(club);
		ra.addFlashAttribute("feedback", "Club created.");
		
		return rv;
		
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addClub", method=RequestMethod.GET)
	public ModelAndView addclub (HttpServletRequest req) {
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);
		String feedback = null;
					
		if (inputFlashMap != null) {
			feedback = (String)inputFlashMap.get("feedback");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("feedback", feedback);
		mv.setViewName("addClubPage");
			
		return mv;
		
	}
	
	@ExceptionHandler({SQLException.class})
	public RedirectView databaseError(SQLException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addClub", true);
		
		// In case a club exist with the same club name
		if (ex.getSQLState().equalsIgnoreCase("23505")) {
			ra.addFlashAttribute("feedback", "A club exists with same name. Please add a club with different name.");
		}
		
		return rv;
		
	}
}
