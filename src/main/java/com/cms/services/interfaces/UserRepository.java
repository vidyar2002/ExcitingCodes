package com.cms.services.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cms.beans.User;
/**
 * Interface to handle operations with Collection - User
 * @author Vidya
 *
 */
public interface UserRepository extends MongoRepository<User, String> {	
	@Query("{ 'email' : ?0 }")
    User findByEmail(String email);
	
	@Query("{ 'email' : ?0, 'password' : ?1, 'registrationStatus' : 'Active'}")
	User findByEmailAndPassword(String email, String password);
	
}
