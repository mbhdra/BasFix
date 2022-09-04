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

import com.mbhdra.basfix.model.Club;
import com.mbhdra.basfix.model.Division;
import com.mbhdra.basfix.model.Gender;
import com.mbhdra.basfix.model.Team;
import com.mbhdra.basfix.service.ClubService;
import com.mbhdra.basfix.service.DivisionService;
import com.mbhdra.basfix.service.GenderService;
import com.mbhdra.basfix.service.TeamService;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private ClubService clubService;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private GenderService genderService;
	
	// Add new team to the system
	@RequestMapping(value="addTeam", method=RequestMethod.POST)
	public RedirectView addTeamPost(HttpServletRequest req, RedirectAttributes ra) {
			
		RedirectView rv = new RedirectView("addTeam", true);
		
		teamService.addTeam(req, new Team());
		ra.addFlashAttribute("feedback", "Team added successfully.");
		
		return rv;
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addTeam", method=RequestMethod.GET)
	public ModelAndView addTeam() {
		
		ModelAndView mv = new ModelAndView();
		List<Club> clubs = new ArrayList<Club>();
		List<Division> divisions = new ArrayList<Division>();
		List<Gender> genders = new ArrayList<Gender>();
		
		clubService.findAllClubs(clubs);
		divisionService.findAllDivisions(divisions);
		genderService.findAllGenders(genders);
		
		mv.addObject("clubs", clubs);
		mv.addObject("divisions", divisions);
		mv.addObject("genders", genders);
		mv.setViewName("addTeamPage");
		
		return mv;
	}
	
	@ExceptionHandler({SQLException.class})
	public RedirectView databaseError(SQLException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addTeam", true);
		
		if (ex.getSQLState().equalsIgnoreCase("23505")) {
			ra.addFlashAttribute("feedback", "A team exists with same club, division, and gender. Please add a team with different information.");
		}
		
		return rv;
	}
}