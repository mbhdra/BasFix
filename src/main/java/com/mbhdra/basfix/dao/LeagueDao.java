package com.mbhdra.basfix.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.League;

@Repository
public interface LeagueDao extends CrudRepository<League, Integer> {

	@Query("from League where league_name=?1 and season_id=?2 and gender_id=?3")
	List<League> checkLeague(String leagueName, int seasonId, int genderId);
}
