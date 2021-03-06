package com.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.user.model.Users;
import com.user.repository.UserRepository;


@SpringBootApplication
@EnableEurekaClient
public class UserProfileServiceApplication implements CommandLineRunner{

	
	@Autowired
	private UserRepository repo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserProfileServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		 List<String> add=new ArrayList<String>();    
		 add.add("A-101, sid, nsp,mum"); 
		if(repo.findAll().isEmpty())
		{
		repo.save(new Users("Max Verstappen","Customer","max33@rb.com","max33","pass","M","Best user","3-3-1997",123L,add));
		repo.save(new Users("Sergio Perez","Merchant","checo11@rb.com","checo11","pass","M","I am merchant","1-1-1980",123L,add));
		}
		for(Users u:repo.findAll())
		{
		System.out.println(u);
		}
	}

}
