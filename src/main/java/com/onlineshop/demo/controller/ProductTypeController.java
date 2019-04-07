package com.onlineshop.demo.controller;


import com.onlineshop.demo.entity.product.ProductType;
import com.onlineshop.demo.repository.ProductTypeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/productType", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class ProductTypeController {
    private ProductTypeRepo productTypeRepo;

    public ProductTypeController(ProductTypeRepo productTypeRepo) {
        this.productTypeRepo = productTypeRepo;
    }

    @PostMapping
    public ResponseEntity<Object> postProductType(@RequestBody ProductType productType){
        ProductType save = productTypeRepo.save(productType);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping
    public List<ProductType> getListProductType(){
        return productTypeRepo.findAll();
    }
}
