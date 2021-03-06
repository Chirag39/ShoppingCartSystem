package com.order.controller;

import java.util.Date;
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

import com.order.entity.Cart;
import com.order.entity.Order;
import com.order.entity.User;
import com.order.entity.Wallet;
import com.order.repository.OrderRepository;
import com.order.repository.WalletRepository;


@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRep;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WalletRepository walletRepo;
	
	
	
	@GetMapping("/order")
	public List<Order> getProduct(){
	 return orderRep.findAll();
	}
	
	@GetMapping("/order/{id}")
	public Order getCartById(@PathVariable String id) {
		return orderRep.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/order")
	public void addOrder(@RequestBody Order o) {
		orderRep.save(o);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/order/create/{userId}/{cartId}")
	public String createNewOrder( @PathVariable String userId ,@PathVariable String cartId) {
		Order o=new Order();
		Cart c= restTemplate.getForObject("http://cart-service/cart/"+cartId, Cart.class);		
		o.setCart(c);
		o.setAmount(o.getAmount()+c.getCartPrice());
		User u=restTemplate.getForObject("http://user-profile-service/user/"+userId, User.class);
		o.setCustId(userId);
		List<String> add=u.getAddress();
		Date date=new Date();
		o.setAddress(add.get(0));
		o.setModeOfPayment("COD");
		o.setOrderStatus("Confirmed");
		o.setOrderDate(date.toString());
		orderRep.save(o);
		return ("New Order Created");
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/order/wallet/{userId}/{cartId}/{walletId}")
	public String OrderByWallet( @PathVariable String userId ,@PathVariable String cartId,@PathVariable String walletId) {
		Order o=new Order();
		Cart c= restTemplate.getForObject("http://cart-service/cart/"+cartId, Cart.class);		
		o.setCart(c);
		o.setAmount(o.getAmount()+c.getCartPrice());
		User u=restTemplate.getForObject("http://user-profile-service/user/"+userId, User.class);
		o.setCustId(userId);
		List<String> add=u.getAddress();
		Date date=new Date();
		o.setAddress(add.get(0));
		
		Wallet w=walletRepo.findById(walletId).orElse(null);
		
		if(w.getAmount()>c.getCartPrice()) { 
			double newBalance=w.getAmount()-c.getCartPrice();
			w.setAmount(newBalance);
			walletRepo.save(w);
			o.setModeOfPayment("Wallet");
			o.setOrderStatus("Confirmed");
			o.setOrderDate(date.toString());
			orderRep.save(o);
			return ("New Order Created");
		}
		
		else return("Insufficient Balance");	
	}
	
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/order/delete/{id}")
	public String deleteCart( @PathVariable String id ) {
		orderRep.deleteById( id );
		return ("Deleted Order Successfully");
	}
	
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
	
	
	
	
	
	
	
	
// modification
	@RequestMapping(method=RequestMethod.POST,value="/order/create")
	public void createOrder() {
		Order o=new Order();
		orderRep.save(o);
	}
	
	@PutMapping("/order/{id}/{cartId}")
	public String placeOrder( @PathVariable String id, @PathVariable String cartId) {	
		Order o=orderRep.findById(id).orElse(null);
		Cart c= restTemplate.getForObject("http://cart-service/cart/"+cartId, Cart.class);	
		o.setOrderId(id);
		o.setCart(c);
		o.setAmount(o.getAmount()+c.getCartPrice());
		orderRep.save(o);
		return ("Order Placed");
	}
	
	@PutMapping("/order/{id}/user/{userId}")
	public String setUser( @PathVariable String id, @PathVariable String userId) {
		Order o=orderRep.findById(id).orElse(null);
		User u=restTemplate.getForObject("http://user-profile-service/user/"+userId, User.class);
		o.setOrderId(id);
		o.setCustId(userId);
		List<String> add=u.getAddress();
		o.setAddress(add.get(0));
		orderRep.save(o);
		return ("Order Placed");
	}
	
	
}
