package com.cms.services.interfaces;

import org.springframework.stereotype.Component;

import com.cms.beans.User;
import com.cms.dto.UserDto;
import com.cms.exception.DataOpsException;

@Component
public interface UserService {

	/**
	 * findByEmail gets the User information based on email
	 * 
	 * @param email
	 * @return User
	 */
	public User findByEmail(String email);

	/**
	 * checks if user already present with the given email address
	 * 
	 * @param emailAddr
	 * @return
	 */
	public boolean checkUserExists(String emailAddr);

	/**
	 * addUser inserts a User entry
	 * 
	 * @param UserDto
	 * @return UserDto
	 */
	public String addUser(UserDto userDto);
	
	/**
	 * getContactList returns the list of Contacts
	 * 
	 * @return UserDto with contact list
	 */
	UserDto getContactList(UserDto userDto) throws DataOpsException;

	
}
