package com.mbhdra.basfix.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mbhdra.basfix.exception.NoAvailableTeamsException;
import com.mbhdra.basfix.model.League;
import com.mbhdra.basfix.model.Team;
import com.mbhdra.basfix.service.LeagueService;
import com.mbhdra.basfix.service.TeamLeagueService;

@Controller
public class TeamLeagueController {
	
	@Autowired
	private LeagueService leagueService;
	
	@Autowired
	private TeamLeagueService teamLeagueService;
	
	// Add new teams to a league
	@RequestMapping(value="addTeamToLeague", method=RequestMethod.POST)
	public RedirectView addTeamToLeaguePost (@RequestParam Team[] selectedTeams, @RequestParam League league, RedirectAttributes ra) {
			
		RedirectView rv = new RedirectView("addTeamToLeague", true);
		teamLeagueService.addTeamsToLeague(league, selectedTeams);
		ra.addFlashAttribute("successFeedback", "Selected teams were added to the league.");
		return rv;
		
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addTeamToLeague", method=RequestMethod.GET)
	public ModelAndView addTeamToLeague() {
		
		ModelAndView mv = new ModelAndView();
		List<League> leagues = leagueService.findAllLeagues();
		mv.addObject("leagues", leagues);
		mv.setViewName("addTeamToLeaguePage");
			
		return mv;
		
	}
	
	// League Selection
	@RequestMapping(value="selectLeague", method=RequestMethod.POST)
	public RedirectView selectLeaguePost(@RequestParam League league, RedirectAttributes ra) throws ServletException, IOException, NoAvailableTeamsException {
			
		RedirectView rv = new RedirectView("selectLeague", true);
		ArrayList<Team> teams = new ArrayList<Team>();
		teamLeagueService.findNotIncludedTeamsByLeague(league, teams);
		ra.addFlashAttribute("league", league);
		ra.addFlashAttribute("teams", teams);
			
		return rv;
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="selectLeague", method=RequestMethod.GET)
	public ModelAndView selectLeague() {
		
		ModelAndView mv = new ModelAndView();
		List<League> leagues = leagueService.findAllLeagues();
		mv.addObject("leagues", leagues);
		mv.setViewName("addTeamToLeaguePage");
			
		return mv;
		
	}
	
	// At least one team must exist that is suitable to the given league (with same division and gender).
	@ExceptionHandler({NoAvailableTeamsException.class})
	public RedirectView noAvailableLeague(NoAvailableTeamsException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addTeamToLeague", true);
		ra.addFlashAttribute("failureFeedback", ex.getMessage());

		return rv;
		
	}
}
