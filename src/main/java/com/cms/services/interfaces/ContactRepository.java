package com.cms.services.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cms.beans.Contact;
/**
 * Interface to handle operations with Collection - Contact
 * @author Vidya
 *
 */
public interface ContactRepository extends MongoRepository<Contact, String> {
	
}
