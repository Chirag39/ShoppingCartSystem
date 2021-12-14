package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.product.model.Product;
import com.product.repository.ProductRepository;


@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRep;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		if(productRep.findAll().isEmpty())
		{
			productRep.save(new Product("Rb16B",200.00,"Car","Sports","Redbull 2021 car",5,"Straight Line speed should improve"));
			productRep.save(new Product("W12",200.00,"Car","Sports","Mercedes 2021 car",5,"Straight Line speed is great"));

		}
		for(Product p:productRep.findAll())
		{
		System.out.println(p);
		}
		
	}

}
