package com.eCommerce.eCommerceDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.eCommerce.eCommerceDemo.Service.ECommerceDataService;
import com.eCommerce.eCommerceDemo.entity.ProductMetadata;
import com.eCommerce.eCommerceDemo.entity.ShopperPersonalizedInfo;

@RestController
public class ECommerceController {
	
	@Autowired private ECommerceDataService eCommerceDataService;

	// Internal Interface - Receive and store personalized information from the data team
    @PostMapping("/internal/personalized_info")
    public String storePersonalizedInfo(@RequestBody ShopperPersonalizedInfo shopperPersonalizedInfo) {
    	eCommerceDataService.saveShopperPersonalizedProductList(shopperPersonalizedInfo);
        return "Received personalized information successfully";
    }

    // Internal Interface - Receive and store product metadata from the data team
    @PostMapping("/internal/product_metadata")
    public String storeProductMetadata(@RequestBody ProductMetadata productMetadata) {
    	eCommerceDataService.saveProductMetadata(productMetadata);
        return "Product metadata stored successfully";
    }

    // External Interface - Provide personalized product information to eCommerce
    @GetMapping("/external/products")
    public List<ProductMetadata> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit) {
        
        
        return ((ECommerceController) eCommerceDataService).getProductsByShopper(shopperId,category,brand,limit);
    }
    
}
