package com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.order.entity.Cart;
import com.order.entity.Order;
import com.order.repository.OrderRepository;


@SpringBootApplication
@EnableEurekaClient
public class OrderServiceApplication implements CommandLineRunner{
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
	
	@Autowired
	private OrderRepository orderRep;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(orderRep.findAll().isEmpty())
		{
			Cart cartDummy=new Cart();
			orderRep.save(new Order("1001",cartDummy,33.00,"10-12-2021","COD","Delivered"));
		}
		for(Order o:orderRep.findAll())
		{
		System.out.println(o);
		}
	}

}
