package com.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.Users;
import com.user.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRep;
	
	@GetMapping("/user")
	public List<Users> getUsers(){
	return userRep.findAll();
	}

	@RequestMapping(method=RequestMethod.POST,value="/user")
	public void addUser(@RequestBody Users u) {
		userRep.save(u);
	}

	@GetMapping("/user/{id}")
	public Users getUserById(@PathVariable String id) {
		return userRep.findById(id).orElse(null);
	}
	
	@GetMapping("/user/name/{fullName}")
	public Users findUserByName( @PathVariable String fullName ){
	return userRep.findUsersByName( fullName );
	}
	
	@GetMapping("/user/mobile/{mobileNumber}")
	public Users findUserByMobile( @PathVariable Long mobileNumber ){
	return userRep.findUsersByMobile( mobileNumber );
	}
	
	@PutMapping("/user/update/{id}")
	public String updateProfile(@RequestBody Users u, @PathVariable String id) {
	u.setId( id );
	userRep.save(u);
	return ("Updated Successfully");
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/user/delete/{id}")
	public String deleteProfile( @PathVariable String id ) {
	userRep.deleteById( id );
	return ("Deleted Successfully");
	}
}
