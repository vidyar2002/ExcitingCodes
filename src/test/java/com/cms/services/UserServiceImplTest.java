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
import com.cms.services.interfaces.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
    private UserService  userService;

    @Before
    public void doSetup() {
    	userService = mock(UserService.class);
    }
   
    
    @Test
    public void testFindByEmail() {
    	User user = new User();
    	user.setEmail("rajesh@yahoo.com");
    	when(userService.findByEmail("vidyar2002@yahoo.com")).thenReturn(user);
    	User returnedUser = userService.findByEmail("vidyar2002@yahoo.com");
    	assertEquals("Email IDs match : ",user.getEmail(), returnedUser.getEmail());
    }
    
   
    @Test
    public void testCheckUserExists() {
    	boolean flag = true;
    	String email = "vidyar2002@yahoo.com";
    	when(userService.checkUserExists(email)).thenReturn(true);
    	boolean returnFlag = userService.checkUserExists(email);
    	assertEquals("Email IDs match : ",flag,returnFlag);
    }
    
    
    @Test
    public void testGetContactList() throws DataOpsException {
    	UserDto userDto = new UserDto();
    	userDto.setEmail("vidyar2002@yahoo.com");
    	
    	UserDto returnUserDto = new UserDto();
    	returnUserDto.setEmail("vidyar2002@yahoo.com");
    	
    	List<ContactDto> returnContactList = new ArrayList<ContactDto>();
    	ContactDto contact = new ContactDto();
    	contact.setEmail("contact1@yahoo.com");
    	contact.setFirstName("Contact 1");
    	returnContactList.add(contact);
    	contact = new ContactDto();
     	contact.setEmail("contact2@yahoo.com");
     	contact.setFirstName("Contact 2");
     	returnContactList.add(contact);
     	returnUserDto.setContactDtoList(returnContactList);
    	
    	
    	when(userService.getContactList(userDto)).thenReturn(returnUserDto);
    	returnUserDto = userService.getContactList(userDto);
    	assertEquals("Email IDs match : ",2,returnUserDto.getContactDtoList().size());
    }
    
}
