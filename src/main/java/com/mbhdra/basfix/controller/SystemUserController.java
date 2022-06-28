package com.mbhdra.basfix.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mbhdra.basfix.model.SystemUser;
import com.mbhdra.basfix.model.UserRole;
import com.mbhdra.basfix.service.SystemUserService;
import com.mbhdra.basfix.service.UserRoleService;

@Controller
public class SystemUserController {
	
	@Autowired
	private SystemUserService systemUserservice;
	
	@Autowired
	private UserRoleService userRoleService;
	
	// Add new user to the system
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public RedirectView addUserPost(SystemUser user, RedirectAttributes ra) {
			
		RedirectView rv = new RedirectView("addUser", true);
		
		systemUserservice.addUser(user);
		ra.addFlashAttribute("feedback", "User added successfully.");
		
		return rv;
		
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addUser", method=RequestMethod.GET)
	public ModelAndView addUser() {
		
		ModelAndView mv = new ModelAndView();
		List<UserRole> userRoles = userRoleService.findAllUserRoles();
		
		mv.addObject("userRoles", userRoles);
		mv.setViewName("addUserPage");
			
		return mv;
		
	}
	
	@ExceptionHandler({SQLException.class})
	public RedirectView databaseError(SQLException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addUser", true);
		
		if (ex.getSQLState().equalsIgnoreCase("23505")) {
			ra.addFlashAttribute("feedback", "A user exists with same username. Please add a user with different username.");
		}
		
		return rv;
		
	}
}
