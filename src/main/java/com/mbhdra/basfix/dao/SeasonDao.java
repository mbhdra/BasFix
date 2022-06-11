package com.mbhdra.basfix.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.Season;

@Repository
public interface SeasonDao extends CrudRepository<Season, Integer> {

}
