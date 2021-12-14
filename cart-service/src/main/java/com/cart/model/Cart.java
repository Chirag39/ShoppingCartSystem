package com.cart.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Cart {
	@Id
	private String cartId;
	@Field
	private List<Product> items;
	@Field
	private double cartPrice;
	
	
	public Cart() {}
	

	public Cart(List<Product> items, double cartPrice) {
		super();
		this.items = items;
		this.cartPrice = cartPrice;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}
	
	public void addItems(Product p) {
		this.items.add(p);
	}

	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", items=" + items + ", cartPrice=" + cartPrice + "]";
	}


	public void removeItem(Product prod) {
		// TODO Auto-generated method stub
		this.items.remove(prod);
	}
	
	
	
}
