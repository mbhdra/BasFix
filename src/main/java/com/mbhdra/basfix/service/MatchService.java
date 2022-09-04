package com.mbhdra.basfix.service;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.MatchDao;
import com.mbhdra.basfix.exception.SameSportsHallDateTimeException;
import com.mbhdra.basfix.exception.SameTeamException;
import com.mbhdra.basfix.exception.TeamsHaveMatchException;
import com.mbhdra.basfix.model.League;
import com.mbhdra.basfix.model.Match;
import com.mbhdra.basfix.model.SportsHall;
import com.mbhdra.basfix.model.Team;

@Service
public class MatchService {
	
	@Autowired
	private MatchDao matchDao;
	
	// Add new match to the system
	public void addMatch(Team aTeam, Team bTeam, SportsHall sportsHall, League league, String date, String time, Match match) 
						throws SameTeamException, SameSportsHallDateTimeException, TeamsHaveMatchException {
		
		// throw exception if two teams are same
		if(aTeam.getTeamId() == bTeam.getTeamId())
			throw new SameTeamException();
		
		// necessary for Time.valuOf() method
		time = time + ":00";
		
		// throw exception if at least one team has a match at given date
		if(matchDao.findMatchByTeamsDate(aTeam, bTeam, Date.valueOf(date)).size() != 0)
			throw new TeamsHaveMatchException();
		
		// throw exception if the sports hall is not available in given date and time
		if(matchDao.findMatchByDateTimeSportsHall(sportsHall, Date.valueOf(date), Time.valueOf(time)).size() != 0)
			throw new SameSportsHallDateTimeException();
		
		match.setaTeam(aTeam);
		match.setbTeam(bTeam);
		match.setSportsHall(sportsHall);
		match.setLeague(league);
		match.setDate(Date.valueOf(date));
		match.setTime(Time.valueOf(time));
		
		matchDao.save(match);
	}
}