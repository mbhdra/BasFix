package com.mbhdra.basfix.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.Gender;

@Repository
public interface GenderDao extends CrudRepository<Gender, Integer> {

}
