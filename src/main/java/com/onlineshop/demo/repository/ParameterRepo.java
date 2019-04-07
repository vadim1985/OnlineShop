package com.onlineshop.demo.repository;

import com.onlineshop.demo.entity.product.Parameter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParameterRepo extends CrudRepository<Parameter, Integer> {
    Optional<Parameter>findByName(String name);

    List<Parameter> findAllByTypeOfParameterId(Integer id);
}
