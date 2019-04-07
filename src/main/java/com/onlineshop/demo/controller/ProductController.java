package com.onlineshop.demo.controller;

import com.onlineshop.demo.entity.product.Product;
import com.onlineshop.demo.repository.ProductRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/product", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class ProductController {
    private ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping
    public ResponseEntity<Object> addParameter (@RequestBody Product product){
        productRepo.save(product);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
