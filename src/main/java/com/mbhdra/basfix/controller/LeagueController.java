package com.mbhdra.basfix.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mbhdra.basfix.model.Division;
import com.mbhdra.basfix.model.Gender;
import com.mbhdra.basfix.model.League;
import com.mbhdra.basfix.model.Season;
import com.mbhdra.basfix.service.LeagueService;
import com.mbhdra.basfix.service.DivisionService;
import com.mbhdra.basfix.service.GenderService;
import com.mbhdra.basfix.service.SeasonService;

@Controller
public class LeagueController {

	@Autowired
	private LeagueService leagueService;
	
	@Autowired
	private SeasonService seasonService;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private GenderService genderService;
	
	// Add new league to the system
	@RequestMapping(value="addLeague", method=RequestMethod.POST)
	public RedirectView addLeaguePost(HttpServletRequest req, RedirectAttributes ra) {
			
		RedirectView rv = new RedirectView("addLeague", true);
		
		leagueService.addLeague(req, new League());
		ra.addFlashAttribute("successFeedback", "League added successfully.");
		
		return rv;
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addLeague", method=RequestMethod.GET)
	public ModelAndView addLeague() {
		
		ModelAndView mv = new ModelAndView();
		List<Season> seasons = new ArrayList<Season>();
		List<Division> divisions = new ArrayList<Division>();
		List<Gender> genders = new ArrayList<Gender>();
		
		seasonService.findAllSeasons(seasons);
		divisionService.findAllDivisions(divisions);
		genderService.findAllGenders(genders);
		
		mv.addObject("seasons", seasons);
		mv.addObject("divisions", divisions);
		mv.addObject("genders", genders);
		mv.setViewName("addLeaguePage");
			
		return mv;
	}
	
	@ExceptionHandler({SQLException.class})
	public RedirectView databaseError(SQLException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addLeague", true);
		
		if (ex.getSQLState().equalsIgnoreCase("23505")) {
			ra.addFlashAttribute("failureFeedback", "A league exists with same season, division, and gender. Please add a league with different information.");
		}
		
		return rv;
	}
}