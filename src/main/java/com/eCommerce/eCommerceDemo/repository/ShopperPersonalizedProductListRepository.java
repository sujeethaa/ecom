package com.eCommerce.eCommerceDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.eCommerceDemo.entity.ShopperPersonalizedInfo;

@Repository
public interface ShopperPersonalizedProductListRepository extends CrudRepository<ShopperPersonalizedInfo, String> {
}