package com.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.user.model.Users;

public interface UserRepository extends MongoRepository <Users,String>{

	@Query("{ 'fullName' : ?0 }")
	Users findUsersByName(String fullName);

	@Query("{ mobileNumber : ?0 }")
	Users findUsersByMobile(Long mobileNumber);
	
//	Users findByUsername(String username);
	
}
