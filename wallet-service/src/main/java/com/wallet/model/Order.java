package com.wallet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Order {
	@Id
	private String orderId;
	@Field
	private String custId;
	@Field
	private Cart cart;
	@Field
	private double amount;
	@Field
	private String orderDate;
	@Field
	private String modeOfPayment;
	@Field
	private String orderStatus;
	@Field
	private String address;
	
	
	public Order() {}
	

	public Order(String custId, Cart cart, double amount, String orderDate, String modeOfPayment,
			String orderStatus) {
		super();
		this.custId = custId;
		this.cart = cart;
		this.amount = amount;
		this.orderDate = orderDate;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
	}





	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getCustId() {
		return custId;
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public String getModeOfPayment() {
		return modeOfPayment;
	}


	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", custId=" + custId + ", address=" + address + ", cart=" + cart + ", amount=" + amount
				+ ", orderDate=" + orderDate + ", modeOfPayment=" + modeOfPayment + ", orderStatus=" + orderStatus
				+ "]";
	}	

	
}
