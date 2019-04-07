package com.onlineshop.demo.controller;

import com.onlineshop.demo.entity.product.ProductCategory;
import com.onlineshop.demo.repository.ProductCategoryRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/productCategory", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class ProductCategoryController {
    private ProductCategoryRepo productCategoryRepo;

    public ProductCategoryController(ProductCategoryRepo productCategoryRepo) {
        this.productCategoryRepo = productCategoryRepo;
    }

    @PostMapping
    public ResponseEntity<Object> postProductCategory(@RequestBody ProductCategory productCategory){
        productCategoryRepo.save(productCategory);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public List<ProductCategory> getProductCategoryByType(@PathVariable("id") int id){
        return productCategoryRepo.findAllByProductTypeId(id);
    }
}
