package com.mbhdra.basfix.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.Match;
import com.mbhdra.basfix.model.SportsHall;
import com.mbhdra.basfix.model.Team;

@Repository
public interface MatchDao extends CrudRepository<Match, Integer>{

	@Query("from Match m where m.sportsHall=?1 and m.date=?2 and m.time=?3")
	List<Match> findMatchByDateTimeSportsHall(SportsHall sportsHall, Date date, Time time);
	
	@Query("from Match m where m.date=?3 and (m.aTeam=?1 or m.bTeam=?1 or m.aTeam=?2 or m.bTeam=?2)")
	List<Match> findMatchByTeamsDate(Team aTeam, Team bTeam, Date date);
	
}
