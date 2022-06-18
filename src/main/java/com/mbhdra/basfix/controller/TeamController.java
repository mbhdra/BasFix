package com.mbhdra.basfix.controller;

import java.sql.SQLException;
import java.util.List;
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
	
	@RequestMapping("addTeamPage")
	public ModelAndView openAddTeamPage() {
		
		ModelAndView mv = new ModelAndView();
		List<Club> clubs = clubService.findAllClubs();
		List<Division> divisions = divisionService.findAllDivisions();
		List<Gender> genders = genderService.findAllGenders();
		mv.addObject("clubs", clubs);
		mv.addObject("divisions", divisions);
		mv.addObject("genders", genders);
		mv.setViewName("addTeamPage");
		
		return mv;
		
	}
	
	// Add new team to the system
	@RequestMapping(value="addTeam", method=RequestMethod.POST)
	public RedirectView addTeamPost (HttpServletRequest req, RedirectAttributes ra){
			
		RedirectView rv = new RedirectView("addTeam", true);
		teamService.addTeam(req, new Team());
		ra.addFlashAttribute("feedback", "Team created.");
		
		return rv;
		
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addTeam", method=RequestMethod.GET)
	public ModelAndView addTeam (HttpServletRequest req) {
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);
		String feedback = null;
					
		if (inputFlashMap != null) {
			feedback = (String)inputFlashMap.get("feedback");
		}
		
		ModelAndView mv = new ModelAndView();
		List<Club> clubs = clubService.findAllClubs();
		List<Division> divisions = divisionService.findAllDivisions();
		List<Gender> genders = genderService.findAllGenders();
		mv.addObject("clubs", clubs);
		mv.addObject("divisions", divisions);
		mv.addObject("genders", genders);
		mv.addObject("feedback", feedback);
		mv.setViewName("addTeamPage");
		
		return mv;
		
	}
	
	@ExceptionHandler({SQLException.class})
	public RedirectView databaseError(SQLException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addTeam", true);
		
		// In case a team exist with the same team name
		if (ex.getSQLState().equalsIgnoreCase("23505")) {
			ra.addFlashAttribute("feedback", "A team exists with same club, division, and gender. Please add a team with different information.");
		}
		
		return rv;
		
	}
}
