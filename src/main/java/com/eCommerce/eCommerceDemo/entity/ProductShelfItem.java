package com.eCommerce.eCommerceDemo.entity;

public class ProductShelfItem {
	
	private String productId;	
	private double relevancyScore;
	
    public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getRelevancyScore() {
		return relevancyScore;
	}
	public void setRelevancyScore(double relevancyScore) {
		this.relevancyScore = relevancyScore;
	}

}
