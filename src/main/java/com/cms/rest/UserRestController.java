package com.cms.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.ServiceResponseDto;
import com.cms.dto.UserDto;
import com.cms.services.interfaces.UserService;

/**
 * RestController to handle all the rest call related to User management
 * 
 * @author Vidya
 *
 */
@RestController
@RequestMapping(value = "/rest/user")
public class UserRestController { 

	private static Logger logger = Logger.getLogger(UserRestController.class);
	
	private UserService userService;
	
	@Autowired
    public UserRestController( UserService userService) {
        this.userService = userService;
    }
	

	/**
	 * checkEmailExists - checks if User exists with the given email id
	 * 
	 * @param request
	 * @param emailAddr
	 * @return ServiceResponseDto with message
	 */
	@RequestMapping(value = "/checkEmailExists", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ServiceResponseDto checkEmailExists(@RequestBody String emailAddr) {
		ServiceResponseDto response = new ServiceResponseDto();
		boolean flag = false;
		flag = userService.checkUserExists(emailAddr);
		if (flag)
			response.setStatusMessage("ERROR : Exists");
		else
			response.setStatusMessage("INFO : Not Exists");

		return response;
	}

	/**
	 * addUser - inserts a User entry to Mongodb
	 * @param request
	 * @param emailAddr
	 * @return
	 */
	@RequestMapping(value = "/addUser", method=RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ServiceResponseDto addUser(@RequestBody UserDto userDto) {
		logger.info("inside add User method");
		ServiceResponseDto response = new ServiceResponseDto();
		String status = userService.addUser(userDto);
		logger.info("status = "+status);
		response.setStatusMessage(status);
		return response;
	}
}
