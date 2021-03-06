package com.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wallet.model.User;
import com.wallet.model.Wallet;
import com.wallet.repository.WalletRepository;

@RestController
public class WalletController {
	
	@Autowired
	private WalletRepository walletRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/wallet")
	public List<Wallet> getWallet(){
	return walletRepo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/wallet")
	public void addWallet(@RequestBody Wallet w) {
		walletRepo.save(w);
	}

	@GetMapping("/wallet/{id}")
	public Wallet getWalletById(@PathVariable String id) {
		return walletRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/wallet/create/{userId}")
	public String createWallet(@PathVariable String userId) {
		Wallet wallet=new Wallet();
		User u=restTemplate.getForObject("http://user-profile-service/user/"+userId, User.class);
		wallet.setCustId(u.getId());
		wallet.setAmount(0);
		walletRepo.save(wallet);
		return ("Wallet assigned to User");
	}
	@PutMapping("/wallet/{id}/add/{money}")
	public String addAmount(@PathVariable String id, @PathVariable long money) {
		Wallet wallet =walletRepo.findById(id).orElse(null);
		wallet.setAmount(wallet.getAmount()+ money);
		walletRepo.save(wallet);
		return ("Added Money to wallet");
	}
	
	@PutMapping("/wallet/rem/{id}/{money}")
	public Wallet deductAmount(@PathVariable String id, @PathVariable String money) {
		Wallet wallet =walletRepo.findById(id).orElse(null);
		long amount=Long.parseLong(money);
		wallet.setAmount(wallet.getAmount()-amount);
		walletRepo.save(wallet);
		return wallet;
	}

	
}
