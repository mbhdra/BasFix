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

import com.mbhdra.basfix.exception.LessThanTwoTeamsException;
import com.mbhdra.basfix.exception.NoAvailableTeamsException;
import com.mbhdra.basfix.exception.SameSportsHallDateTimeException;
import com.mbhdra.basfix.exception.SameTeamException;
import com.mbhdra.basfix.exception.TeamsHaveMatchException;
import com.mbhdra.basfix.model.League;
import com.mbhdra.basfix.model.Match;
import com.mbhdra.basfix.model.SportsHall;
import com.mbhdra.basfix.model.Team;
import com.mbhdra.basfix.service.LeagueService;
import com.mbhdra.basfix.service.MatchService;
import com.mbhdra.basfix.service.SportsHallService;
import com.mbhdra.basfix.service.TeamLeagueService;

@Controller
public class MatchController {
	
	@Autowired
	private LeagueService leagueService;
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private TeamLeagueService teamLeagueService;
	
	@Autowired
	private SportsHallService sportsHallService;
	
	// Add new match to a league
	@RequestMapping(value="addMatch", method=RequestMethod.POST)
	public RedirectView addMatchePost(@RequestParam Team aTeam, @RequestParam Team bTeam, @RequestParam League league, 
											@RequestParam SportsHall sportsHall, @RequestParam String date, @RequestParam String time, 
											RedirectAttributes ra) throws SameTeamException, SameSportsHallDateTimeException, TeamsHaveMatchException {
			
		RedirectView rv = new RedirectView("addMatch", true);
		
		matchService.addMatch(aTeam, bTeam, sportsHall, league, date, time, new Match());
		ra.addFlashAttribute("successFeedback", "Match added to the league.");
		
		return rv;
		
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addMatch", method=RequestMethod.GET)
	public ModelAndView addMatch() {
		
		ModelAndView mv = new ModelAndView();
		List<League> leagues = leagueService.findAllLeagues();
		
		mv.addObject("leagues", leagues);
		mv.setViewName("addMatchPage");
			
		return mv;
		
	}
	
	// League Selection
	@RequestMapping(value="selectLeagueToAddMatch", method=RequestMethod.POST)
	public RedirectView selectLeagueToAddMatchPost(@RequestParam League league, RedirectAttributes ra) throws ServletException, IOException, NoAvailableTeamsException, LessThanTwoTeamsException {
			
		RedirectView rv = new RedirectView("selectLeagueToAddMatch", true);
		ArrayList<Team> teams = new ArrayList<Team>();
		ArrayList<SportsHall> sportsHalls = new ArrayList<SportsHall>();
		
		teamLeagueService.findAllTeamsByLeague(league, teams);
		sportsHallService.findAllSportHalls(sportsHalls);
		
		ra.addFlashAttribute("league", league);
		ra.addFlashAttribute("teams", teams);
		ra.addFlashAttribute("sportsHalls", sportsHalls);
			
		return rv;
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="selectLeagueToAddMatch", method=RequestMethod.GET)
	public ModelAndView selectLeagueToAddMatch() {
		
		ModelAndView mv = new ModelAndView();
		List<League> leagues = leagueService.findAllLeagues();
		
		mv.addObject("leagues", leagues);
		mv.setViewName("addMatchPage");
			
		return mv;
		
	}
	
	// The team number must be at least 2 to add a match.
	@ExceptionHandler({LessThanTwoTeamsException.class})
	public RedirectView noAvailableLeague(LessThanTwoTeamsException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addMatch", true);
		
		ra.addFlashAttribute("failureFeedback", ex.getMessage());

		return rv;
		
	}
	
	// Two teams must be different
	@ExceptionHandler({SameTeamException.class})
	public RedirectView sameTeam(SameTeamException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addMatch", true);
		
		ra.addFlashAttribute("failureFeedback", ex.getMessage());

		return rv;
		
	}
	
	// There cannot be a match in same sports hall, date, and time
	@ExceptionHandler({SameSportsHallDateTimeException.class})
	public RedirectView sameSportsHallDateTime(SameSportsHallDateTimeException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addMatch", true);
		
		ra.addFlashAttribute("failureFeedback", ex.getMessage());

		return rv;
		
	}
	
	// At least one team has another match at given date
	@ExceptionHandler({TeamsHaveMatchException.class})
	public RedirectView teamsHaveMatch(TeamsHaveMatchException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addMatch", true);
		
		ra.addFlashAttribute("failureFeedback", ex.getMessage());

		return rv;
		
	}
}
