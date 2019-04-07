package com.onlineshop.demo.repository;

import com.onlineshop.demo.entity.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer> {
}
