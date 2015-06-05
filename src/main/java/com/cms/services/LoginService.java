package com.cms.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cms.beans.User;
import com.cms.dto.CurrentUser;
import com.cms.services.interfaces.UserService;

@Service
public class LoginService implements UserDetailsService {
	
	private static Logger logger = Logger.getLogger(LoginService.class);
	
	private final UserService userService;
	
	@Autowired
	public LoginService(UserService userService)
	{
		logger.info("calling login service constructor");
		this.userService = userService;
	}
	
    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
    	logger.info("Authenticating user with email={}");
        User user = userService.findByEmail(email);
		if (user == null) {
			 throw new UsernameNotFoundException(String.format("User %s does not exist!", email));
		}  
        return new CurrentUser(user);
    }

}
