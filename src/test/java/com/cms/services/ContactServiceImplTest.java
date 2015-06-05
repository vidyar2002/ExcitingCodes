package com.cms.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.cms.beans.Contact;
import com.cms.beans.User;
import com.cms.dto.ContactDto;
import com.cms.dto.UserDto;
import com.cms.exception.DataOpsException;
import com.cms.services.interfaces.ContactService;
import com.cms.services.interfaces.UserService;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceImplTest {
	
    private ContactService  contactService;

    @Before
    public void doSetup() {
    	contactService = mock(ContactService.class);
    }
   
    @Test
    public void testIsContactExists() {
    	ContactDto input = new ContactDto();
    	input.setFirstName("First Name");
    	input.setLastName("Last Name");
    	input.setEmail("contact@yahoo.com");
    	
    	boolean flag = true;
    	
    	when(contactService.isContactExists(input)).thenReturn(true);
    	boolean returnFlag = contactService.isContactExists(input);
    	assertEquals("Email IDs match : ",flag,returnFlag);
    }
    
    @Test
    public void testFindContact() {
    	String userEmail = "user@yahoo.com";
    	String contactEmail = "contact@yahoo.com";
    	ContactDto returnDto = new ContactDto();
    	returnDto.setFirstName("First  Name");
    	returnDto.setLastName("Last  Name");
    	returnDto.setEmail("contact@yahoo.com");
    	returnDto.setUserEmail(userEmail);
    	
    	when(contactService.findContact(userEmail, contactEmail)).thenReturn(returnDto);
    	ContactDto returnedDto = contactService.findContact(userEmail, contactEmail);
    	assertEquals("Email IDs match : ",returnDto.getEmail(),returnedDto.getEmail());
    }
}
