package com.eCommerce.eCommerceDemo.entity;

import jakarta.persistence.Entity;

@Entity
public class ProductMetadata {

	private String productId;	
	private String category;
    private String brand;
    
    public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public ProductMetadata(String productId, String category, String brand) {
		super();
		this.productId = productId;
		this.category = category;
		this.brand = brand;
	}
	
}
