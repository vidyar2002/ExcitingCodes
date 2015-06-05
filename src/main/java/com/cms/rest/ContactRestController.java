package com.cms.rest;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.ContactDto;
import com.cms.dto.CurrentUser;
import com.cms.dto.ServiceResponseDto;
import com.cms.dto.UserDto;
import com.cms.exception.DataOpsException;
import com.cms.services.interfaces.ContactService;
import com.cms.services.interfaces.UserService;

/**
 * RestController to handle all the rest call related to User mangement
 * 
 * @author Vidya
 *
 */
@RestController
@RequestMapping(value = "/rest/contact")
public class ContactRestController { 

	private static Logger logger = Logger.getLogger(ContactRestController.class);
	
	private UserService userService;
	
	private ContactService contactService;
	
	@Autowired
    public ContactRestController( UserService userService, ContactService contactService) {
        this.userService = userService;
        this.contactService = contactService;
    }
	
	/**
	 * getContactList - retrieves the list of contacts
	 * 
	 * @return ServiceResponseDto with message
	 */
	@RequestMapping(value = "/getContactList", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ServiceResponseDto getContactList(HttpServletRequest request, Authentication authentication) {
		ServiceResponseDto response = new ServiceResponseDto();
		try {
			 UserDto userDto = new UserDto();
			 String loggedInUserEmail = "";			 
			 CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();				 
			loggedInUserEmail = currentUser.getUsername();
			userDto.setEmail(loggedInUserEmail);
			userDto = userService.getContactList(userDto);
			userDto.setEmail(loggedInUserEmail);
			response.setPayload(userDto);
		} catch (DataOpsException e) {
			response.setStatusMessage("ERROR : "+e.getMessage());
			logger.error("Exception : "+e.getMessage());
		}		
		return response;
	} 
	
	/**
	 * addContact - to add a new contact information
	 * @param ContactDto
	 * @return ServiceResponseDto with message
	 */
	@RequestMapping(value = "/saveContact",  method = RequestMethod.POST, produces = "application/json", consumes="application/json")
	@ResponseBody
	public ServiceResponseDto saveContact(@RequestBody ContactDto contactDto) {
		ServiceResponseDto response = new ServiceResponseDto();
		if(contactDto == null)
		{
			response.setStatusMessage("ERROR : ContactDto is null");
		}
		else
		{
			boolean exists = contactService.isContactExists(contactDto);
			if(!exists)
			{
				try {
					ContactDto dto = contactService.saveContact(contactDto);
					response.setStatusMessage("Contact added successfully "+dto.getEmail());
				} catch (DataOpsException e) {
					response.setStatusMessage("ERROR : "+e.getMessage());
					logger.info("exception : "+e.getMessage());					
				}
			}
			else
			{
				response.setStatusMessage("ERROR : Contact already exists");
			}
		}
		return response;
	} 
	
	
	
	/**
	 * checkContactExists - to check if contact already exists with email
	 * @param ContactDto
	 * @return ServiceResponseDto with message
	 */
	@RequestMapping(value = "/checkContactExists",  method = RequestMethod.POST, produces = "application/json", consumes="application/json")
	@ResponseBody
	public ServiceResponseDto checkContactExists(@RequestBody ContactDto contactDto) {
		ServiceResponseDto response = new ServiceResponseDto();
		if(contactDto == null)
		{
			response.setStatusMessage("ERROR : ContactDto is null");
		}
		else
		{
			boolean exists = contactService.isContactExists(contactDto);
			if(!exists)
			{
				response.setStatusMessage("INFO : "+exists);
			}
			else
			{
				response.setStatusMessage("ERROR : Contact already exists with the same email address");
			}
		}
		return response;
	} 
	
	
	
	/**
	 * addContact - to add a new contact information
	 * @param ContactDto
	 * @return ServiceResponseDto with message
	 */
	@RequestMapping(value = "/findContactDetails",  method = RequestMethod.POST, produces = "application/json", consumes="application/json")
	@ResponseBody
	public ServiceResponseDto findContactDetails(@RequestBody ContactDto contactDto) {
		ServiceResponseDto response = new ServiceResponseDto();
		if(contactDto == null)
		{
			response.setStatusMessage("ERROR : ContactDto is null");
		}
		else
		{
			contactDto = contactService.findContact(contactDto.getUserEmail(), contactDto.getEmail());			
			if(contactDto != null)
			{
				response.setPayload(contactDto);
				response.setStatusMessage("success");
			}
			else
			{
				response.setStatusMessage("ERROR : Contact information not available");
			}
		}
		return response;
	} 
	
	
	/**
	 * removeContact - to remove a contact from the user's list
	 * @param ContactDto
	 * @return ServiceResponseDto with message
	 */
	@RequestMapping(value = "/removeContact",  method = RequestMethod.POST, produces = "application/json", consumes="application/json")
	@ResponseBody
	public ServiceResponseDto removeContact(@RequestBody ContactDto contactDto) {
		ServiceResponseDto response = new ServiceResponseDto();
		if(contactDto == null)
		{
			response.setStatusMessage("ERROR : ContactDto is null");
		}
		else
		{
			try {
				contactService.removeContact(contactDto.getUserEmail(), contactDto.getId());
				response.setStatusMessage("INFO :success");
			} catch (DataOpsException e) {
				response.setStatusMessage("ERROR : "+e.getMessage());
			}			
		}
		return response;
	} 
	
}
