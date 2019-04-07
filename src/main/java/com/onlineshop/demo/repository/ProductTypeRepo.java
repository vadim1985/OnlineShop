package com.onlineshop.demo.repository;

import com.onlineshop.demo.entity.product.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductTypeRepo extends CrudRepository<ProductType, Integer> {
    List<ProductType>findAll();
}
