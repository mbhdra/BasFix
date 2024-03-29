package com.mbhdra.basfix.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.SystemUser;

@Repository
public interface SystemUserDao extends CrudRepository<SystemUser, Integer> {
	
	SystemUser findByUname(String uname);
}