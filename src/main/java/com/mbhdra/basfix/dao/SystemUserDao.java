package com.mbhdra.basfix.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mbhdra.basfix.model.SystemUser;

public interface SystemUserDao extends CrudRepository<SystemUser, Integer> {
	
	SystemUser findByUname(String uname);
	
	@Query("from SystemUser where uname=?1 and upass=?2")
	List<SystemUser> checkUser(String uname, String upass);
}
