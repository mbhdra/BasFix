package com.mbhdra.basfix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.UserRoleDao;
import com.mbhdra.basfix.model.UserRole;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	public List<UserRole> findAllUserRoles() {
		
		Iterable<UserRole> userRoles =  userRoleDao.findAll();
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		
		for (UserRole r : userRoles)
			userRoleList.add(r);
		
		return userRoleList;
		
	}
}
