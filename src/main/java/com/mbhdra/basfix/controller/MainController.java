package com.mbhdra.basfix.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home () {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "homePage";
        }
 
        return "welcomePage";
        
	}

	@RequestMapping("login")
	public String loginPage () {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "loginPage";
        }
        
        return "welcomePage";
        
	}
	
	@RequestMapping("welcome")
	public String welcomePage () {
		
		return "welcomePage";
		
	}
	
	// handle login failure
	@RequestMapping(value="loginError", method=RequestMethod.POST)
	public RedirectView loginError (RedirectAttributes ra) {
		
		RedirectView rv = new RedirectView("loginError", true);
		ra.addFlashAttribute("feedback", "Login failed. Check your credentials!");
		return rv;
		
	}
	
	// PRG pattern completion to prevent double form submission
	@RequestMapping(value="loginError", method=RequestMethod.GET)
	public void loginError (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(req);
		String feedback = null;
					
		if (inputFlashMap != null) {
			feedback = (String)inputFlashMap.get("feedback");
		}
		
		req.setAttribute("feedback", feedback);
		RequestDispatcher dispatcher = req.getRequestDispatcher("login");
		dispatcher.forward(req, res);
		
	}
}
