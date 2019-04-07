package com.onlineshop.demo.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypeOfParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message="Name of parameter type is required")
    private String name;

    public TypeOfParameter(@NotBlank(message = "Name of parameter type is required") String name) {
        this.name = name;
    }
}