package com.mbhdra.basfix.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.DivisionDao;
import com.mbhdra.basfix.dao.GenderDao;
import com.mbhdra.basfix.dao.LeagueDao;
import com.mbhdra.basfix.dao.SeasonDao;
import com.mbhdra.basfix.model.Division;
import com.mbhdra.basfix.model.Gender;
import com.mbhdra.basfix.model.League;
import com.mbhdra.basfix.model.Season;

@Service
public class LeagueService {
	
	@Autowired
	private LeagueDao leagueDao;
	
	@Autowired
	private SeasonDao seasonDao;
	
	@Autowired
	private DivisionDao divisionDao;
	
	@Autowired
	private GenderDao genderDao;
	
	public void addLeague (HttpServletRequest req)  {
		
		String leagueName = "";
		League league = new League();
		
		int seasonId = Integer.parseInt(req.getParameter("season"));
		int divisionId = Integer.parseInt(req.getParameter("division"));
		int genderId = Integer.parseInt(req.getParameter("gender"));
		
		Season season = seasonDao.findById(seasonId).get();
		Division division = divisionDao.findById(divisionId).get();
		Gender gender = genderDao.findById(genderId).get();
		
		leagueName = season.getSeasonName() + " " + division.getDivisionName() + " " + gender.getGenderName().substring(0,1).toUpperCase()
				   + gender.getGenderName().substring(1) + " League";
		league.setLeagueName(leagueName);
		league.setSeason(season);
		league.setDivision(division);
		league.setGender(gender);
		leagueDao.save(league);
		
	}
}
