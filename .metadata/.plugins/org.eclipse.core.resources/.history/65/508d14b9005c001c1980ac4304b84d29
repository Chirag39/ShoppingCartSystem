package com.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository <User,String>{

	@Query("{ 'fullName' : ?0 }")
	User findUsersByName(String fullName);

	@Query("{ mobileNumber : ?0 }")
	User findUsersByMobile(Long mobileNumber);
	
}
