package com.mbhdra.basfix.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.SystemUserDao;
import com.mbhdra.basfix.model.SystemUser;

@Service
public class SystemUserService {

	@Autowired
	SystemUserDao dao;
	
	public void addUser (SystemUser user)  {
		
		// bcrypt password and save user
		int strength = 12; // work factor of bcrypt
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
		user.setUpass(bCryptPasswordEncoder.encode(user.getUpass()));
		
		dao.save(user);
		
	}
}
