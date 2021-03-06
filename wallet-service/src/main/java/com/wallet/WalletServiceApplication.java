package com.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.wallet.model.Wallet;
import com.wallet.repository.WalletRepository;

@SpringBootApplication
@EnableEurekaClient
public class WalletServiceApplication implements CommandLineRunner{
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(WalletServiceApplication.class, args);
	}

	@Autowired
	private WalletRepository walletRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(walletRepo.findAll().isEmpty()) {
			walletRepo.save(new Wallet(1000,"001"));
		}
		
		for(Wallet w:walletRepo.findAll()) {
			System.out.println(w);
		}
	}

}
