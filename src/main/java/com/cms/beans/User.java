package com.cms.beans;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity mapped to User table in Mongo db
 * @author Vidya
 * 
 */
@Document
public class User {

    @Id
    private String id;
    private String email;

    private String firstName;
    private String lastName;
    private String password;
    private String registrationStatus;
    private List<Contact> contactList;

    public User() {}

    

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


	public List<Contact> getContactList() {
		return contactList;
	}



	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}



	@Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}

