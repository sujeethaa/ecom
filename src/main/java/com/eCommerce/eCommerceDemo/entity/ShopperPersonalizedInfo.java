package com.eCommerce.eCommerceDemo.entity;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class ShopperPersonalizedInfo {
	
	private String shopperId;
	private List<ProductShelfItem> shelf;
	
    public String getShopperId() {
		return shopperId;
	}
	public void setShopperId(String shopperId) {
		this.shopperId = shopperId;
	}
	public List<ProductShelfItem> getShelf() {
		return shelf;
	}
	public void setShelf(List<ProductShelfItem> shelf) {
		this.shelf = shelf;
	}
	

}
