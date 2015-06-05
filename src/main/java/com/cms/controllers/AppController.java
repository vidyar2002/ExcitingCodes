package com.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * AppController handles the request to index page
 * @author Vidya
 *
 */ 
@Controller
@RequestMapping(value = "/")
public class AppController {

	/**
	 * loadIndexPage loads the index.htm page
	 * @param view
	 * @param model
	 * @return 
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String loadIndexPage(ModelAndView view, Model model) {
		model.addAttribute("contentUrl","UserHome.jsp");
		return "template"; 
	}
}
