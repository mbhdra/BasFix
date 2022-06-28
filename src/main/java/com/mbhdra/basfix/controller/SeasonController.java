package com.mbhdra.basfix.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mbhdra.basfix.exception.InvalidSeasonException;
import com.mbhdra.basfix.model.Season;
import com.mbhdra.basfix.service.SeasonService;

@Controller
public class SeasonController {
	
	@Autowired
	private SeasonService seasonService;
	
	// Add new season to the system
	@RequestMapping(value="addSeason", method=RequestMethod.POST)
	public RedirectView addSeasonPost(HttpServletRequest req, RedirectAttributes ra) throws InvalidSeasonException {
		
		RedirectView rv = new RedirectView("addSeason", true);
		
		seasonService.addSeason(req, new Season());
		ra.addFlashAttribute("feedback", "Season added successfully.");
		
		return rv;
		
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addSeason", method=RequestMethod.GET)
	public ModelAndView addSeason() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("addSeasonPage");
			
		return mv;
		
	}
	
	@ExceptionHandler({SQLException.class})
	public RedirectView databaseError(SQLException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addSeason", true);
		
		if (ex.getSQLState().equalsIgnoreCase("23505")) {
			ra.addFlashAttribute("feedback", "A season exists with same starting and ending years. Please add a season with different starting and ending years.");
		}
		
		return rv;
		
	}
	
	// Ending year must be bigger than starting year and the difference between them must be 1.
	@ExceptionHandler({InvalidSeasonException.class})
	public RedirectView invalidSeason(InvalidSeasonException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addSeason", true);
		
		ra.addFlashAttribute("feedback", ex.getMessage());

		return rv;
		
	}
}
