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

import com.mbhdra.basfix.model.Division;
import com.mbhdra.basfix.service.DivisionService;

@Controller
public class DivisionController {
	
	@Autowired
	private DivisionService divisionService;
	
	// Add new division to the system
	@RequestMapping(value="addDivision", method=RequestMethod.POST)
	public RedirectView addDivisionPost(Division division, RedirectAttributes ra) {

		RedirectView rv = new RedirectView("addDivision", true);
		
		divisionService.addDivision(division);
		ra.addFlashAttribute("feedback", "Division added successfully.");
		
		return rv;	
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addDivision", method=RequestMethod.GET)
	public ModelAndView addDivision() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("addDivisionPage");
			
		return mv;	
	}
	
	@ExceptionHandler({SQLException.class})
	public RedirectView databaseError(SQLException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addDivision", true);
		
		if (ex.getSQLState().equalsIgnoreCase("23505")) {
			ra.addFlashAttribute("feedback", "A division exists with same name. Please add a division with different name.");
		}
		
		return rv;	
	}
}