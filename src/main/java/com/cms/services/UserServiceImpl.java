package com.cms.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cms.beans.User;
import com.cms.dto.ContactDto;
import com.cms.dto.UserDto;
import com.cms.exception.DataOpsException;
import com.cms.services.interfaces.UserRepository;
import com.cms.services.interfaces.UserService;
import com.cms.util.ContactBuilder;

/**
 * 
 * @author Vidya
 *
 */

@Component
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ContactBuilder builder;

	public UserServiceImpl() {

	}

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}


	/**
	 * findByEmail gets the User information based on email
	 * 
	 * @param email
	 * @return User
	 */
	@Override
	public User findByEmail(String email) {
		logger.info("inside findByEmail  of UserServiceImpl");
		User user = repository.findByEmail(email);
		return user;
	}

	/**
	 * checks if user already present with the given email address
	 * 
	 * @param emailAddr
	 * @return
	 */
	@Override
	public boolean checkUserExists(String emailAddr) {
		logger.info("inside service checkEmailExists");
		User user = findByEmail(emailAddr);
		return (user == null) ? false : true;
	}

	@Override
	public String addUser(UserDto userDto) {
		logger.info("inside service addUser");
		User user = null;
		boolean flag = checkUserExists(userDto.getEmail());
		if (!flag) {
			user = new User();
			user.setEmail(userDto.getEmail());
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedPassword = encoder.encode(userDto.getPassword());
			user.setPassword(encodedPassword);
			user.setRegistrationStatus("Active");
			user = repository.save(user);
			if (user != null)
				return "Success";
			else
				return "ERROR";
		} else
			return "Duplicate";
	}
	
	/**
	 * getContactList returns the list of Contacts
	 * 
	 * @return UserDto with contact List
	 */
	@Override
	public UserDto getContactList(UserDto userDto) throws DataOpsException {
		
		User user = findByEmail(userDto.getEmail());
		if(user != null)
		{
		List<ContactDto> contactDtoList = builder.populateListOfContactDTO(user.getContactList());	
		userDto.setContactDtoList(contactDtoList);
		}
		else
			throw new DataOpsException("User information not found");
		return userDto;
	}
	
}