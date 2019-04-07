package com.onlineshop.demo.controller;


import com.onlineshop.demo.entity.product.TypeOfParameter;
import com.onlineshop.demo.repository.TypeOfParameterRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/typeOfParameter", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class TypeOfParameterController {
    private TypeOfParameterRepo typeOfParameterRepo;

    public TypeOfParameterController(TypeOfParameterRepo typeOfParameterRepo) {
        this.typeOfParameterRepo = typeOfParameterRepo;
    }

    @PostMapping
    public ResponseEntity<Object> postTypeOfParameter(@RequestBody TypeOfParameter typeOfParameter){
        TypeOfParameter save = typeOfParameterRepo.save(typeOfParameter);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping
    public List<TypeOfParameter> getListTypeOfParameter(){
        return typeOfParameterRepo.findAll();
    }
}
