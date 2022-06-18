package com.mbhdra.basfix.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.ClubDao;
import com.mbhdra.basfix.dao.DivisionDao;
import com.mbhdra.basfix.dao.GenderDao;
import com.mbhdra.basfix.dao.TeamDao;
import com.mbhdra.basfix.model.Team;

@Service
public class TeamService {
	
	@Autowired
	private TeamDao teamDao;
	
	@Autowired
	private ClubDao clubDao;
	
	@Autowired
	private DivisionDao divisionDao;
	
	@Autowired
	private GenderDao genderDao;
	
	public void addTeam(HttpServletRequest req, Team team)  {
		
		String teamName = "";
		
		int clubId = Integer.parseInt(req.getParameter("club"));
		int divisionId = Integer.parseInt(req.getParameter("division"));
		int genderId = Integer.parseInt(req.getParameter("gender"));
		
		team.setClub(clubDao.findById(clubId).get());
		team.setDivision(divisionDao.findById(divisionId).get());
		team.setGender(genderDao.findById(genderId).get());
		
		teamName = team.getClub().getClubName() + " " + team.getDivision().getDivisionName() + " " + 
				team.getGender().getGenderName().substring(0,1).toUpperCase() + team.getGender().getGenderName().substring(1) + " Team";
		team.setTeamName(teamName);
		teamDao.save(team);
		
	}
}
