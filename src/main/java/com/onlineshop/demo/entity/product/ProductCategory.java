package com.onlineshop.demo.entity.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;
    @NotBlank(message="Name of product category is required")
    private String name;

    public ProductCategory(ProductType productType, @NotBlank(message = "Name of product category is required") String name) {
        this.productType = productType;
        this.name = name;
    }
}
