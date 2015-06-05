
package com.cms.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * UserController handles all the requests related to User
 * @author Vidya
 *
 */
@Controller

public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	/**
	 * loadSignupPage loads the SignupUser.htm page
	 * @param view
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String loadSignupPage(ModelAndView view, Model model) {
		logger.debug("REQUEST FOR SIGNUP PAGE SENT");
		model.addAttribute("contentUrl","SignupUser.jsp"); 
		return "template"; 
	}
}
