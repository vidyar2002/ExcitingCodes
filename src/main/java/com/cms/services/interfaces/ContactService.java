package com.cms.services.interfaces;

import org.springframework.stereotype.Component;

import com.cms.dto.ContactDto;
import com.cms.exception.DataOpsException;

@Component
public interface ContactService {

	
	/**
	 * saveContact - save the contact entry into db
	 * @param dto
	 * @return
	 * @throws DataOpsException
	 */
	ContactDto saveContact(ContactDto dto) throws DataOpsException;
	
	/**
	 * checks if the contact exists for a user
	 * @param contactDto
	 * @return
	 */
	boolean isContactExists(ContactDto contactDto);
	
	
	ContactDto findContact(String userEmail, String contactEmail);
	
	/**
	 * remove contact from the user's contact list
	 * @param userEmail
	 * @param contactId
	 */	
	void removeContact(String userEmail, String contactId) throws DataOpsException;
	
}
