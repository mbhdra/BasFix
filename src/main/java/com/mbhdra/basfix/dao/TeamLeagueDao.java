package com.mbhdra.basfix.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.Division;
import com.mbhdra.basfix.model.Gender;
import com.mbhdra.basfix.model.League;
import com.mbhdra.basfix.model.Team;
import com.mbhdra.basfix.model.TeamLeague;

@Repository
public interface TeamLeagueDao extends CrudRepository<TeamLeague, Integer> {

	// find all teams that suitable with and not exists in the given league
	@Query("select t from Team t where t.division=?1 and t.gender=?2 and t not in (select tl.team from TeamLeague tl where tl.league=?3)")
	List<Team> findNotIncludedTeamsByLeague(Division division, Gender gender, League league);
	
}
