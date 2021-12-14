package com.order.entity;


//class just to catch the Rest Template call

public class Product {
	
	private String productId;
	private String productName;
	private String productType;
	private String category;
	private double price;
	private String description;
	private int rating;
	private String review;
	
	
	
	public Product() {}
	
	
	public Product( String productName,  double price, String productType, String category, 
			String description, int rating, String review) {
		super();
		this.productName = productName;
		this.price = price;
		this.productType = productType;
		this.category = category;
		this.description = description;
		this.rating = rating;
		this.review = review;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", category=" + category + ", price=" + price + ", description=" + description + ", rating=" + rating
				+ ", review=" + review + "]";
	}
	
	
}
