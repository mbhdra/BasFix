package com.mbhdra.basfix.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.TeamLeagueDao;
import com.mbhdra.basfix.exception.NoAvailableTeamsException;
import com.mbhdra.basfix.model.League;
import com.mbhdra.basfix.model.Team;
import com.mbhdra.basfix.model.TeamLeague;

@Service
public class TeamLeagueService {
	
	@Autowired
	private TeamLeagueDao teamLeagueDao;
	
	public void findNotIncludedTeamsByLeague(League league, ArrayList<Team> teams) throws NoAvailableTeamsException {
		
		teams.addAll(teamLeagueDao.findNotIncludedTeamsByLeague(league.getDivision(), league.getGender(), league));
		if(teams.size() == 0)
			throw new NoAvailableTeamsException();
		
	}
	
	public void addTeamsToLeague(League league, Team[] teams) {
		
		for (Team t : teams) {
			
			TeamLeague teamLeague = new TeamLeague();
			teamLeague.setLeague(league);
			teamLeague.setTeam(t);
			teamLeagueDao.save(teamLeague);
			
		}
	}
}
