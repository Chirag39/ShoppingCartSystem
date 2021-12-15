package com.order.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Wallet {
	@Id
	private String walletId;
	@Field
	private double amount;
	@Field
	private String custId;
	
	public Wallet() {}

	
	
	public Wallet(long amount, String custId) {
		super();
		this.amount = amount;
		this.custId = custId;
	}


	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double d) {
		this.amount = d;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}



	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", amount=" + amount + ", custId=" + custId + "]";
	}
	
	

}
