package com.mbhdra.basfix.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.League;

@Repository
public interface LeagueDao extends CrudRepository<League, Integer> {
	
}
