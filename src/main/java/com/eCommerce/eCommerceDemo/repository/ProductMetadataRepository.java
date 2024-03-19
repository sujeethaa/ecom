package com.eCommerce.eCommerceDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.eCommerceDemo.entity.ProductMetadata;


public interface ProductMetadataRepository extends JpaRepository<ProductMetadata, String> {
    ProductMetadata findByProductId(String productId);
    }
