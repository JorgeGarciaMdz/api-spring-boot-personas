package com.jorge.api.service;

import java.util.List;

import com.jorge.api.entity.Provincia;
import com.jorge.api.exception.EntityNotFoundException;


public interface ProvinciaService {
    
    List<Provincia> findAll();
    void create(Provincia provincia);
    Provincia findById(Long id) throws EntityNotFoundException;
    void delete(Long id);
}
