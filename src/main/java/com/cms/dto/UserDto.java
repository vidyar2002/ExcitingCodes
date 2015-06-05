package com.cms.dto;

import java.util.List;

import com.cms.beans.User;

/**
 * Entity mapped to User table in Mongo db
 * @author Vidya
 *
 */
public class UserDto {

   
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String registrationStatus;
    private List<ContactDto> contactDtoList;

    public UserDto()
    {
    	
    }
    
    public UserDto(User user) {
    	if(user != null)
    	{
	    	this.id = user.getId();
	    	this.email = user.getEmail();
	    	this.firstName = user.getFirstName();
	    	this.lastName = user.getLastName();
	    	this.password = user.getPassword();
	    	this.registrationStatus = user.getRegistrationStatus();
    	}
    }


    public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	
	
	public List<ContactDto> getContactDtoList() {
		return contactDtoList;
	}

	public void setContactDtoList(List<ContactDto> contactDtoList) {
		this.contactDtoList = contactDtoList;
	}

	/**
	 * Generates User entity from DTO
	 * @return
	 */
	public User generateUser()
	{
		User user = new User();
		user.setId(this.id);
		user.setEmail(this.email);
		user.setFirstName(this.firstName);
		user.setLastName(this.lastName);
		user.setRegistrationStatus(this.registrationStatus);
		return user;
	}


	@Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', lastName='%s',email='%s', password='%s', registrationStatus='%s']",
                id, firstName, lastName,email, password, registrationStatus);
    }

}

