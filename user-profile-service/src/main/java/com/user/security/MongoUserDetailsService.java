//package com.user.security;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.user.model.Users;
//import com.user.repository.UserRepository;
//@Component
//public class MongoUserDetailsService implements UserDetailsService{
//	
//	@Autowired
//	private UserRepository userRep;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		Users user=userRep.findByUsername(username);
//		
//		if(user == null) {
//		      throw new UsernameNotFoundException("User not found");
//		    }
//		 List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
//		    return new User(user.getUsername(), user.getPassword(), authorities);
//		  }
//	
//
//}
