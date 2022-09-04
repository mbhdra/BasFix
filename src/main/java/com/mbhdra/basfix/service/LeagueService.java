package com.mbhdra.basfix.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.DivisionDao;
import com.mbhdra.basfix.dao.GenderDao;
import com.mbhdra.basfix.dao.LeagueDao;
import com.mbhdra.basfix.dao.SeasonDao;
import com.mbhdra.basfix.model.League;

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
	
	public int addLeague(HttpServletRequest req, League league) {
		
		String leagueName = "";
		
		int seasonId = Integer.parseInt(req.getParameter("season"));
		int divisionId = Integer.parseInt(req.getParameter("division"));
		int genderId = Integer.parseInt(req.getParameter("gender"));
		
		league.setSeason(seasonDao.findById(seasonId).get());
		league.setDivision(divisionDao.findById(divisionId).get());
		league.setGender(genderDao.findById(genderId).get());
		
		leagueName = league.getSeason().getSeasonName() + " " + league.getGender().getGenderName().substring(0,1).toUpperCase() + league.getGender().getGenderName().substring(1) +
				" " + league.getDivision().getDivisionName() + " League";
		league.setLeagueName(leagueName);
		leagueDao.save(league);
		
		return league.getLeagueId();
	}
	
	public void findAllLeagues(List<League> leagues) {
		
		for (League l : leagueDao.findAll())
			leagues.add(l);
	}
}