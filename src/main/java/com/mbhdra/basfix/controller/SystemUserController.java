package com.mbhdra.basfix.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
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
	
	@RequestMapping("addUserPage")
	public ModelAndView openAddUserPage() {
		
		ModelAndView mv = new ModelAndView();
		List<UserRole> userRoles = userRoleService.findAllUserRoles();
		mv.addObject("userRoles", userRoles);
		mv.setViewName("addUserPage");		
		
		return mv;
		
	}
	
	// Add new user to the system
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public RedirectView addUserPost (SystemUser user, RedirectAttributes ra) {
			
		RedirectView rv = new RedirectView("addUser", true);
		systemUserservice.addUser(user);
		ra.addFlashAttribute("feedback", "User saved.");
		
		return rv;
		
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="addUser", method=RequestMethod.GET)
	public ModelAndView addUser (HttpServletRequest req) {
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);
		String feedback = null;
					
		if (inputFlashMap != null) {
			feedback = (String)inputFlashMap.get("feedback");
		}
		
		ModelAndView mv = new ModelAndView();
		List<UserRole> userRoles = userRoleService.findAllUserRoles();
		mv.addObject("userRoles", userRoles);
		mv.addObject("feedback", feedback);
		mv.setViewName("addUserPage");
			
		return mv;
		
	}
	
	@ExceptionHandler({SQLException.class})
	public RedirectView databaseError(SQLException ex, RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("addUser", true);
		
		// In case a user exist with the same username
		if (ex.getSQLState().equalsIgnoreCase("23505")) {
			ra.addFlashAttribute("feedback", "A user exists with same username. Please add a user with different username.");
		}
		
		return rv;
		
	}
}
