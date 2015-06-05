package com.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.beans.Contact;
import com.cms.beans.User;
import com.cms.dto.ContactDto;
import com.cms.exception.DataOpsException;
import com.cms.services.interfaces.ContactService;
import com.cms.services.interfaces.UserRepository;
import com.cms.services.interfaces.UserService;
import com.cms.util.ContactBuilder;

/**
 * 
 * @author Vidya
 *
 */

@Component
public class ContactServiceImpl implements ContactService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ContactBuilder builder;

	public ContactServiceImpl() {

	}

	@Autowired
	public ContactServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * checks if the contact exists for a user
	 * @param contactDto
	 * @return
	 */
	@Override
	public boolean isContactExists(ContactDto contactDto)
	{
		User user = userService.findByEmail(contactDto.getUserEmail());
		List<Contact> contactList = user.getContactList();
		boolean flag = false;
		if(contactList != null)
		{
			if(contactDto.getId() != null)
			{
				for(Contact contact : contactList)
				{
					if(!(contact.getId().equals(contactDto.getId())) && contact.getEmail().equals(contactDto.getEmail()))
					{
						flag = true;
						break;
					}
				}
			}
			else
			{
				for(Contact contact : contactList)
				{
					if(contact.getEmail().equals(contactDto.getEmail()))
						flag = true;
						break;
				}
			}
		}
		return flag;
			
	}
	
	
	/**
	 * saveContact - insert / update the contact entry based on the action
	 * @param dto
	 * @return
	 * @throws DataOpsException
	 */
	@Override
	public ContactDto saveContact(ContactDto contactDto) throws DataOpsException {
		if (contactDto == null) {
			throw new DataOpsException("Contact Dto is null");
		} else {
			User user = repository.findByEmail(contactDto.getUserEmail());
			if (user != null) {
				
				if(contactDto.getId() == null)
				{
					addContact(user, contactDto);
				}
				else
				{
					updateContact(user, contactDto);
				}

			} else
				throw new DataOpsException("User not found");
		}
		return contactDto;
	}
	
	/**
	 * addContact  - to add a new contact entry
	 * @param user
	 * @param contactDto
	 */
	private void addContact(User user, ContactDto contactDto)
	{
		if(contactDto != null && contactDto.getId() == null)
		{
			Contact contact = builder.populateContact(contactDto);
			List<Contact> contactList = user.getContactList();
			if (contactList == null)
				contactList = new ArrayList<Contact>();
			contactList.add(contact);
			user.setContactList(contactList);
			repository.save(user);
		}
	}
	
	/**
	 * updateContact - to update existing contact entry
	 * @param user
	 * @param contactDto
	 */
	private void updateContact(User user, ContactDto contactDto)
	{
		if(contactDto != null && contactDto.getId() != null)
		{
			List<Contact> contactList = user.getContactList();
			for(Contact contact : contactList)
			{
				if(contact.getId().equals(contactDto.getId()))
				{
					contact.setFirstName(contactDto.getFirstName());
					contact.setLastName(contactDto.getLastName());
					contact.setMobile(contactDto.getMobile());
					contact.setEmail(contactDto.getEmail());
					break;
				}
			}
			user.setContactList(contactList);
			repository.save(user);
		}
	}
	
	
	@Override
	public ContactDto findContact(String userEmail, String contactEmail) {
		User user = userService.findByEmail(userEmail);
		ContactDto contactDto = null;
		if(user != null)
		{
			List<Contact> contactList = user.getContactList();
			for(Contact contact : contactList)
			{
				if(contact.getEmail().equals(contactEmail))
				{
					contactDto = builder.populateContactDto(contact);
					contactDto.setUserEmail(userEmail);
					break;
				}
					
			}
		}
		
		
		return contactDto;
	}
	
	/**
	 * remove contact from the user's contact list
	 * @param userEmail
	 * @param contactId
	 */
	@Override
	public void removeContact(String userEmail, String contactId) throws DataOpsException
	{
		User user = userService.findByEmail(userEmail);
		int position = -1;
		if(user != null)
		{   int i = 0;
			List<Contact> contactList = user.getContactList();
			for(Contact contact : contactList)
			{
				if(contact.getId().equals(contactId)){
					position = i;
					break;
				}
				i++;
			}
			if(position != -1)
				contactList.remove(position);
			
			user.setContactList(contactList);
			repository.save(user);
		}
		else
			throw new DataOpsException("User not found");
	}
	
}