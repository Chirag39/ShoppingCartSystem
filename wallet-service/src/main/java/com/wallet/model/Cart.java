package com.wallet.model;

import java.util.List;
// class just to catch the Rest Template call


public class Cart {
	private String cartId;
	private List<Product> items;
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
	
	public void removeItems(Product p) {
		this.items.remove(p);
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
	
	
	
}
