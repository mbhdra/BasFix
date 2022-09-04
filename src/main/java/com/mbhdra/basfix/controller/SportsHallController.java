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

import com.mbhdra.basfix.model.SportsHall;
import com.mbhdra.basfix.service.SportsHallService;

@Controller
public class SportsHallController {

	@Autowired
	private SportsHallService sportsHallService;
	
	// Add new sports hall to the system
	@RequestMapping(value="addSportsHall", method=RequestMethod.POST)
	public RedirectView addSportsHall(SportsHall sportsHall, RedirectAttributes ra) {

		RedirectView rv = new RedirectView("addSportsHall", true);
		
		sportsHallService.addSportsHall(sportsHall);
		ra.addFlashAttribute("feedback", "Sports hall added successfully.");
		
		return rv;
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addSportsHall", method=RequestMethod.GET)
	public ModelAndView addSportsHall() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("addSportsHallPage");
			
		return mv;
	}
	
	@ExceptionHandler({SQLException.class})
	public RedirectView databaseError(SQLException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addSportsHall", true);
		
		if (ex.getSQLState().equalsIgnoreCase("23505")) {
			ra.addFlashAttribute("feedback", "A sports hall exists with same name. Please add a sports hall with different name.");
		}
		
		return rv;
	}
}