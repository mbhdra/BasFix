package com.mbhdra.basfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		
		return "login";
	}
	
	@RequestMapping("/welcome")
	public String welcomePage() {
		
		return "welcome";
	}
	
	@RequestMapping("/logout")
	public String logoutPage() {
		
		return "logout";
	}
}
