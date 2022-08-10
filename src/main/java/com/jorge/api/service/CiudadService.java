package com.jorge.api.service;

import java.util.List;

import com.jorge.api.dto.CiudadDTO;
import com.jorge.api.entity.Ciudad;
import com.jorge.api.exception.EntityNotFoundException;

public interface CiudadService {
    
    List<Ciudad> findAll();
    Ciudad findById(Long id) throws EntityNotFoundException;
    void create(CiudadDTO ciudadDTO) throws EntityNotFoundException;
    void delete(Long id);
}
