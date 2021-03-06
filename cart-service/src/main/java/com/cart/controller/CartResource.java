package com.cart.controller;

import java.util.ArrayList;
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

import com.cart.model.Cart;
import com.cart.model.Product;
import com.cart.repository.CartRepository;




@RestController
public class CartResource {

	@Autowired
	private RestTemplate restTemplate;
	
//	private Cart cart;
	
	@Autowired
	private CartRepository cartRep;
	
	
	@GetMapping("/cart")
	public List<Cart> getProduct(){
	return cartRep.findAll();
	}
	
	@GetMapping("/cart/{id}")
	public Cart getCartById(@PathVariable String id) {
		return cartRep.findById(id).orElse(null);
	}
	

	@RequestMapping(method=RequestMethod.POST,value="/cart")
	public void addItem(@RequestBody Cart c) {
		cartRep.save(c);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cart/create")
	public void createCart() {
		Cart c=new Cart();
		List<Product> empty= new ArrayList<Product>();
		c.setItems(empty);
		cartRep.save(c);
	}
	
	@PutMapping("/cart/{id}/{productId}")
	public String addProduct(@PathVariable String id, @PathVariable String productId) {
		Cart c=cartRep.findById(id).orElse(null);
		Product p= restTemplate.getForObject("http://product-service/product/"+productId, Product.class);
//		c.setCartId(id);
		c.addItems(p);
		c.setCartPrice(c.getCartPrice()+p.getPrice());
		cartRep.save(c);
		
		return ("Added the Product to cart");
	}
	
	@PutMapping("/cart/update/{id}")
	public String updateCart(@RequestBody Cart c, @PathVariable String id) {
		c.setCartId(id);
		cartRep.save(c);
		return ("Updated the Cart");
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/cart/delete/{id}")
	public String deleteCart( @PathVariable String id ) {
		cartRep.deleteById( id );
		return ("Deleted Cart Successfully");
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/cart/rem/{id}/{productId}")
	public String removeProduct(@PathVariable String id, @PathVariable int productId) {
		Cart c=cartRep.findById(id).orElse(null);		
		Product prod=c.getItems().get(productId-1);
		c.removeItem(prod);
		c.setCartPrice(c.getCartPrice()-prod.getPrice());
		
		cartRep.save(c);
		
		return ("Removed the Product from cart");
	}
	
	
//	@RequestMapping("cart/{id}")
//	public User getUser(@PathVariable("id") String id) {
//		User user= restTemplate.getForObject("http://user-profile-service/user/"+id, User.class);
//		System.out.println(user.getId());
//		
//		return user;
//	}
	
//	@RequestMapping("cart/{id}")
//	public Product getAddProduct(@PathVariable("id") String id) {
//		Product p= restTemplate.getForObject("http://product-service/product/"+id, Product.class);
//		System.out.println(p.getProductName());
//		List<Product> items=new ArrayList<Product>();
//		items.add(p);
//		Cart cart1=new Cart(items,p.getPrice());
//		System.out.println(cart1);
//		return p;
//	}
	
}
