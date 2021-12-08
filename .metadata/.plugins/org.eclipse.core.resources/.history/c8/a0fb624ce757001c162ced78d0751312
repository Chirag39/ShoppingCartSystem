package com.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CartResource {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("cart/{id}")
	public User getUser(@PathVariable("id") String id) {
		User user= restTemplate.getForObject("http://user-profile-service/user/"+id, User.class);
		System.out.println(user.getId());
		
		return user;
	}
	
	
}
