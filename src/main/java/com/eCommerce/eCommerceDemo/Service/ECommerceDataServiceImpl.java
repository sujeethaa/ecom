package com.eCommerce.eCommerceDemo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import com.eCommerce.eCommerceDemo.entity.ProductMetadata;
import com.eCommerce.eCommerceDemo.entity.ProductShelfItem;
import com.eCommerce.eCommerceDemo.entity.ShopperPersonalizedInfo;
import com.eCommerce.eCommerceDemo.repository.ProductMetadataRepository;
import com.eCommerce.eCommerceDemo.repository.ShopperPersonalizedProductListRepository;

@Service
public class ECommerceDataServiceImpl implements ECommerceDataService{

	@Autowired
    private ProductMetadataRepository productMetadataRepository;
    
    @Autowired
    private ShopperPersonalizedProductListRepository shopperPersonalizedProductListRepository;
    
    @Override
    public void saveShopperPersonalizedProductList(ShopperPersonalizedInfo list) {
    	shopperPersonalizedProductListRepository.save(list);
    }

    @Override
    public void saveProductMetadata(ProductMetadata metadata) {
    	productMetadataRepository.save(metadata);
    }
    
    @Override public List<ShopperPersonalizedInfo> fetchShopperPersonalizedInfoList()
    {
        return (List<ShopperPersonalizedInfo>)
        		shopperPersonalizedProductListRepository.findAll();
    }
    
    @Override public ProductMetadata fetchProductMetadataByID(String productId)
    {
    	ProductMetadata metaData = productMetadataRepository.findByProductId(productId);
    	return metaData;
    }
    
	
    public List<ProductMetadata> getProductsByShopper(String shopperId, String category, String brand, int limit) {
    	
    	List<ShopperPersonalizedInfo> personalizedInfoList= fetchShopperPersonalizedInfoList();
    	List<ProductMetadata> result = null;
        
        Optional<ShopperPersonalizedInfo> optionalInfo = personalizedInfoList.stream()
                .filter(info -> info.getShopperId().equals(shopperId))
                .findFirst();

        
        if (optionalInfo.isPresent()) {
            ShopperPersonalizedInfo shopperPersonalizedInfo = optionalInfo.get();
            System.out.println(shopperPersonalizedInfo);
        } else {
            System.out.println("ShopperPersonalizedInfo not found for ID: " + shopperId);
        }
        
        if (optionalInfo.isPresent()) {
        	List<ProductShelfItem> shelf = optionalInfo.get().getShelf();
            
         // Apply filters
            List<ProductShelfItem> filteredShelf = shelf;
            
            if (category != null)
                filteredShelf = filteredShelf.stream().filter(item -> fetchProductMetadataByID(item.getProductId()).getCategory().equals(brand)).collect(Collectors.toList());

            if (brand != null)
                filteredShelf = filteredShelf.stream().filter(item -> fetchProductMetadataByID(item.getProductId()).getBrand().equals(brand)).collect(Collectors.toList());

            // Limit the number of products
            filteredShelf = filteredShelf.stream().limit(limit).collect(Collectors.toList());

            // Retrieve product metadata for filtered products
            return filteredShelf.stream().map(item -> fetchProductMetadataByID(item.getProductId())).collect(Collectors.toList());
        } else {
            System.out.println("ShopperPersonalizedInfo not found for ID: " + shopperId);
        }
		return result;
        
        
    }
}
