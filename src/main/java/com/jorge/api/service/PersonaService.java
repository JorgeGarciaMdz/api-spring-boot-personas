package com.jorge.api.service;

import java.util.List;

import com.jorge.api.dto.PersonaDTO;
import com.jorge.api.entity.Persona;
import com.jorge.api.exception.EntityNotFoundException;

public interface PersonaService {
    
    public List<Persona> findAll();
    public void create(PersonaDTO personaDTO);
    public void delete(Long id);
    public Persona findById(Long id) throws EntityNotFoundException;
}
