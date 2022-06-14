package com.mbhdra.basfix.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.Division;

@Repository
public interface DivisionDao extends CrudRepository<Division, Integer>{

}
