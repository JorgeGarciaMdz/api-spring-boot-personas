package com.jorge.api.restController;

import java.util.Optional;

import com.jorge.api.buildError.HandlerError;
import com.jorge.api.dto.ProvinciaDTO;
import com.jorge.api.exception.EntityNotFoundException;
import com.jorge.api.mapper.ProvinciaMapper;
import com.jorge.api.service.ProvinciaService;

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
@RequestMapping("/api/v1/provincia")
public class ProvinciaRestController {

    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private ProvinciaMapper provinciaMapper;

    @Autowired
    private HandlerError handlerError;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(provinciaMapper.mapperListProvincia2ListProvinciaDTO(provinciaService.findAll()), HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> findById(@RequestParam(name = "id") Long id){
        try {
            return new ResponseEntity<>(provinciaMapper.mapperProvincia2ProvinciaDTO(provinciaService.findById(id)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.errorResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody ProvinciaDTO provinciaDTO, BindingResult result){
        if(result.hasErrors())
            return new ResponseEntity<>(handlerError.getErrors(result), HttpStatus.UNPROCESSABLE_ENTITY);
        provinciaService.create(provinciaMapper.mapperProvinciaDTO2Provincia(provinciaDTO));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@Validated @RequestBody ProvinciaDTO provinciaDTO, BindingResult result, @RequestParam(name = "id", required = false) Long id){
        if(result.hasErrors())
            return new ResponseEntity<>(handlerError.getErrors(result), HttpStatus.UNPROCESSABLE_ENTITY);
        Optional.ofNullable(id).ifPresent( i -> provinciaDTO.setId(id));
        provinciaService.create(provinciaMapper.mapperProvinciaDTO2Provincia(provinciaDTO));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> deleted(@RequestParam(name = "id") Long id){
        Optional.of(id).ifPresent(i -> provinciaService.delete(i));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
