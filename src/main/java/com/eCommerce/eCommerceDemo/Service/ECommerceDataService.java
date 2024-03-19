package com.eCommerce.eCommerceDemo.Service;

import java.util.List;
import java.util.Optional;

import com.eCommerce.eCommerceDemo.entity.ProductMetadata;
import com.eCommerce.eCommerceDemo.entity.ShopperPersonalizedInfo;

public interface ECommerceDataService {

	public void saveShopperPersonalizedProductList(ShopperPersonalizedInfo list);
	public void saveProductMetadata(ProductMetadata metadata);
	public List<ShopperPersonalizedInfo> fetchShopperPersonalizedInfoList();
	public ProductMetadata fetchProductMetadataByID(String productId);
	/*
	 * public ProductMetadata fetchProductMetadataByCategory(String category);
	 * public ProductMetadata fetchProductMetadataByBrand(String brand);
	 */
}
