package com.mbhdra.basfix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.SystemUserDao;
import com.mbhdra.basfix.model.SystemUser;

@Service
public class SystemUserDetailsService implements UserDetailsService {

	@Autowired
	private SystemUserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SystemUser user = dao.findByUname(username);

		if (user == null)
			throw new UsernameNotFoundException("User 404");
		
		return new SystemUserDetailsImpl(user);
		
	}
}
