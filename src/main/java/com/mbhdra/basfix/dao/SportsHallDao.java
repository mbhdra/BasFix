package com.mbhdra.basfix.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.SportsHall;

@Repository
public interface SportsHallDao extends CrudRepository<SportsHall, Integer> {

}