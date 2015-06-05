package com.cms.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cms.beans.Contact;
import com.cms.dto.ContactDto;

@Component
public class ContactBuilder {
	
	/**
	 * populate ContactDto from contact
	 * @param contact
	 * @return
	 */
	public ContactDto populateContactDto(Contact contact)
	{
		ContactDto contactDto = null;
		if(contact != null)
		{
			contactDto = new ContactDto();
			contactDto.setId(contact.getId());
			contactDto.setFirstName(contact.getFirstName());
			contactDto.setLastName(contact.getLastName());
			contactDto.setEmail(contact.getEmail());
			contactDto.setMobile(contact.getMobile());
		}		
		return contactDto;
	}
	
	/**
	 * populate the dto list from list of contacts
	 * @param contactList
	 * @return
	 */
	public List<ContactDto> populateListOfContactDTO(List<Contact> contactList)
	{
		List<ContactDto> contactDtoList = null;
		if(contactList != null)
		{
			contactDtoList = new ArrayList<ContactDto>();
			for(Contact contact : contactList)
			{
				contactDtoList.add(populateContactDto(contact));
			}
		}
		return contactDtoList;
	}
	
	
	/**
	 * populate Contact entity from ContactDto
	 * @param contactDto
	 * @return Contact
	 */
	public Contact populateContact(ContactDto contactDto)
	{
		Contact contact = null;
		if(contactDto != null)
		{ 	
			if(contactDto.getId() == null)		
				contact = new Contact();
			else
				contact = new Contact(contactDto.getId());
			contact.setFirstName(contactDto.getFirstName());
			contact.setLastName(contactDto.getLastName());
			contact.setEmail(contactDto.getEmail());
			contact.setMobile(contactDto.getMobile());
		}		
		return contact;
	}
}
