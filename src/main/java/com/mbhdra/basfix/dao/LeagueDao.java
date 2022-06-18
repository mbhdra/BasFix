package com.mbhdra.basfix.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.League;

@Repository
public interface LeagueDao extends CrudRepository<League, Integer> {

	@Query("from League where season_id=?1 and division_id=?2 and gender_id=?3")
	List<League> checkLeague(int seasonId, int divisionId, int genderId);
}
