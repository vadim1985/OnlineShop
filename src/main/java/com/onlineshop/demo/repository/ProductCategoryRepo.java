package com.onlineshop.demo.repository;

import com.onlineshop.demo.entity.product.ProductCategory;
import com.onlineshop.demo.entity.product.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCategoryRepo extends CrudRepository<ProductCategory, Integer> {
    List<ProductCategory> findAllByProductTypeId(Integer id);
}
