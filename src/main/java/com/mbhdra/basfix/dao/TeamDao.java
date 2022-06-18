package com.mbhdra.basfix.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.Team;

@Repository
public interface TeamDao extends CrudRepository<Team, Integer> {

}
