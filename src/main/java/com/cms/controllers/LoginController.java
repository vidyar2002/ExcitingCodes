package com.cms.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	/**
	 * loadIndexPage loads the login page
	 * @param view
	 * @param model
	 * @return 
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	 public ModelAndView getLoginPage( Model model, @RequestParam(value = "error", required = false) Optional<String> error){
		 model.addAttribute("contentUrl","UserLogin.jsp");
	        return new ModelAndView("template", "error", error);
	  }
	
	
	/**
	 * loadHomePage loads the home page
	 * @param view
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String loadHomePage(HttpServletRequest request, Model model) {
			model.addAttribute("contentUrl","UserHome.jsp"); 
			return "template"; 
	}
	
	
	/**
	 * logout page invalidates session and loads the login page
	 * @param view
	 * @param model
	 * @return 
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(true);
		session.invalidate();
		model.addAttribute("contentUrl","UserLogin.jsp");
		return "template"; 
	}	
	
}
