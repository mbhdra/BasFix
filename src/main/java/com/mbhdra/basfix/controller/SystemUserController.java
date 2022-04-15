package com.mbhdra.basfix.controller;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbhdra.basfix.dao.SystemUserDao;
import com.mbhdra.basfix.model.SystemUser;
import com.mbhdra.basfix.service.SystemUserService;

@Controller
public class SystemUserController {
	
	@Autowired
	SystemUserService service;
	
	@RequestMapping("/addUser")
	public String addUser (SystemUser user) {
		
		service.addUser(user);
		return "register";
	}
}
