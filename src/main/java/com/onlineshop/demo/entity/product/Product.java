package com.onlineshop.demo.entity.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
    @NotBlank(message="Name of product is required")
    private String name;
    @NotBlank(message="Description is required")
    private String description;
    @ManyToMany(targetEntity = Parameter.class)
    private List<Parameter> parameters;
}
