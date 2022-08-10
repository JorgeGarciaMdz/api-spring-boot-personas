package com.jorge.api.restController;

import java.util.Optional;

import com.jorge.api.buildError.HandlerError;
import com.jorge.api.dto.CiudadDTO;
import com.jorge.api.exception.EntityNotFoundException;
import com.jorge.api.mapper.CiudadMapper;
import com.jorge.api.service.CiudadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/ciudad")
public class CiudadRestController {
    
    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private CiudadMapper ciudadMapper;

    @Autowired
    private HandlerError handlerError;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(ciudadMapper.mapperListCiudad2ListCiudadDTO(ciudadService.findAll()), HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> findByid(@RequestParam(name = "id", required = true) Long id){
        try {
            return new ResponseEntity<>(ciudadMapper.mapperCiudad2CiudadDTO(ciudadService.findById(id)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.errorResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody CiudadDTO ciudadDTO, BindingResult result ){
        if(result.hasErrors())
            return new ResponseEntity<>(handlerError.getErrors(result) ,HttpStatus.UNPROCESSABLE_ENTITY);
        try {
            ciudadService.create(ciudadDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(handlerError.getErrors(result) ,HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping(params = "id")
    public ResponseEntity<?> update(@Validated @RequestBody CiudadDTO ciudadDTO, BindingResult result, @RequestParam(name = "id", required = true) Long id){
        if(result.hasErrors())
            return new ResponseEntity<>(handlerError.getErrors(result) ,HttpStatus.UNPROCESSABLE_ENTITY);
        try {
            Optional.ofNullable(id).ifPresent(i -> ciudadDTO.setId(i));
            ciudadService.create(ciudadDTO);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(handlerError.getErrors(result) ,HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> deleted(@RequestParam(name = "id", required = true) Long id){
        ciudadService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
