package com.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.cart.model.Cart;
import com.cart.model.Product;
import com.cart.repository.CartRepository;


@SpringBootApplication
@EnableEurekaClient
public class CartServiceApplication implements CommandLineRunner{

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}
	
	@Autowired
	private CartRepository cartRep;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(cartRep.findAll().isEmpty())
		{
			List<Product> items=new ArrayList<Product>();
			cartRep.save(new Cart(items,33.00));
		}
		for(Cart c:cartRep.findAll())
		{
		System.out.println(c);
		}
	}

}
