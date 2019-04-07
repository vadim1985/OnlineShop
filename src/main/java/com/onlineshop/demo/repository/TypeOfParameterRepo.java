package com.onlineshop.demo.repository;

import com.onlineshop.demo.entity.product.TypeOfParameter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeOfParameterRepo extends CrudRepository<TypeOfParameter, Integer> {
    List<TypeOfParameter>findAll();
}
