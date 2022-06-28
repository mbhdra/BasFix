package com.mbhdra.basfix.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mbhdra.basfix.model.Club;
import com.mbhdra.basfix.service.ClubService;

@Controller
public class ClubController {
	
	@Autowired
	ClubService clubService;
	
	// Add new club to the system
	@RequestMapping(value="addClub", method=RequestMethod.POST)
	public RedirectView addclubPost(Club club, RedirectAttributes ra) {

		RedirectView rv = new RedirectView("addClub", true);
		
		clubService.addClub(club);
		ra.addFlashAttribute("feedback", "Club added successfully.");
		
		return rv;
		
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addClub", method=RequestMethod.GET)
	public ModelAndView addclub() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("addClubPage");
			
		return mv;
		
	}
	
	@ExceptionHandler({SQLException.class})
	public RedirectView databaseError(SQLException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addClub", true);
		
		if (ex.getSQLState().equalsIgnoreCase("23505")) {
			ra.addFlashAttribute("feedback", "A club exists with same name. Please add a club with different name.");
		}
		
		return rv;
		
	}
}
