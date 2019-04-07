package com.onlineshop.demo.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message="Name of parameter is required")
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_of_parameter_id")
    private TypeOfParameter typeOfParameter;

    public Parameter(@NotBlank(message = "Name of parameter is required") String name) {
        this.name = name;
    }
}