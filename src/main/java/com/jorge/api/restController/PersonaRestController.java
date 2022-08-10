package com.jorge.api.restController;

import java.util.Optional;

import com.jorge.api.buildError.HandlerError;
import com.jorge.api.dto.PersonaDTO;
import com.jorge.api.exception.EntityNotFoundException;
import com.jorge.api.mapper.PersonaMapper;
import com.jorge.api.service.PersonaService;

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
@RequestMapping("/api/v1/persona")
public class PersonaRestController {
    
    private final PersonaService personaService;
    private final PersonaMapper personaMapper;
    private final HandlerError handlerError;

    @Autowired
    public PersonaRestController(PersonaService personaService, PersonaMapper personaMapper, HandlerError handlerError){
        this.personaService = personaService;
        this.personaMapper = personaMapper;
        this.handlerError = handlerError;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(personaMapper.mapperListPersona2ListPersonaDTO(personaService.findAll()), HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> findById(@RequestParam(name = "id", required = true) Long id){
        try {
            return new ResponseEntity<>(personaMapper.mapperPersona2PersonaDTO(personaService.findById(id)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.errorResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody PersonaDTO personaDTO, BindingResult result){
        if(result.hasErrors())
            return new ResponseEntity<>(handlerError.getErrors(result), HttpStatus.UNPROCESSABLE_ENTITY);
        personaService.create(personaDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(params = "id")
    public ResponseEntity<?> update(@Validated @RequestBody PersonaDTO personaDTO, BindingResult result, @RequestParam(name = "id") Long id){
        if(result.hasErrors())
            return new ResponseEntity<>(handlerError.getErrors(result), HttpStatus.UNPROCESSABLE_ENTITY);
        Optional.ofNullable(id).ifPresent( i -> personaDTO.setId(i));
        personaService.create(personaDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<?> delete(@RequestParam(name = "id", required = true) Long id){
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
