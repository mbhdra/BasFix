package com.mbhdra.basfix.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.Club;

@Repository
public interface ClubDao extends CrudRepository<Club, Integer> {

}