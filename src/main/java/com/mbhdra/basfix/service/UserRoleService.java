package com.mbhdra.basfix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.UserRoleDao;
import com.mbhdra.basfix.model.UserRole;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	public void findAllUserRoles(List<UserRole> userRoles) {
		
		for (UserRole u : userRoleDao.findAll())
			userRoles.add(u);
	}
}