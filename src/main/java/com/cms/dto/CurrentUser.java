package com.cms.dto;

import org.springframework.security.core.authority.AuthorityUtils;

import com.cms.beans.User;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	private User user;
    private String fullName;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("testrole"));
        this.user = user;
        this.fullName = user.getFirstName()+" "+user.getLastName();
    }
    
    @Override
    public String getUsername() {
    	return user.getEmail();
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return user.getId();
    }

//    public Role getRole() {
//        return user.getRole();
//    }

    public String getFullName()
    {
    	return user.getFirstName()+" "+user.getLastName();
    }
    
    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
