package com.onlineshop.demo.controller;

import com.onlineshop.demo.entity.product.Parameter;
import com.onlineshop.demo.repository.ParameterRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/parameter", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class ParameterController {
    private ParameterRepo parameterRepo;

    public ParameterController(ParameterRepo parameterRepo) {
        this.parameterRepo = parameterRepo;
    }

    @GetMapping(value = "/{id}")
    public List<Parameter> getListParameterByType(@PathVariable("id") int id){
        return parameterRepo.findAllByTypeOfParameterId(id);
    }

    @PostMapping
    public ResponseEntity<Object> postParameter(@RequestBody List<Parameter> parameters){
        Integer idTypeOfParameter = parameters.get(0).getTypeOfParameter().getId();
        List<Parameter> allTypeOfParameterId = parameterRepo.findAllByTypeOfParameterId(idTypeOfParameter);
        findAndRemoveParameters(allTypeOfParameterId, parameters);
        parameters.forEach(i -> parameterRepo.save(i));
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    private void findAndRemoveParameters (List<Parameter> allTypeOfParameterId, List<Parameter> parametersFromRequest){
        for (Parameter parameter : allTypeOfParameterId) {
            for (int i = 0; i < parametersFromRequest.size(); i++) {
                if (parameter.getName().equalsIgnoreCase(parametersFromRequest.get(i).getName())) {
                    parametersFromRequest.remove(i);
                }
            }
        }
    }
}
