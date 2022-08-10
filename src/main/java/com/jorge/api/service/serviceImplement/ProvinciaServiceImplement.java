package com.jorge.api.service.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.api.entity.Provincia;
import com.jorge.api.exception.EntityNotFoundException;
import com.jorge.api.repository.ProvinciaRepository;
import com.jorge.api.service.ProvinciaService;

@Service
public class ProvinciaServiceImplement implements ProvinciaService{

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<Provincia> findAll() {
        return provinciaRepository.findByDeleted(Boolean.FALSE);
    }

    @Override
    public void create(Provincia provincia) {
        provinciaRepository.save(provincia);        
    }

    @Override
    public Provincia findById(Long id) throws EntityNotFoundException {
        Optional<Provincia> provincia = provinciaRepository.findByIdAndDeleted(id, Boolean.FALSE);
        if (provincia.isPresent()) {
            return provincia.get();
        } else
            throw new EntityNotFoundException("Not found entity with ID: " + id);
    }

    @Override
    public void delete(Long id) {
        try {
            Provincia provincia = findById(id);
            provincia.setDeleted(true);
            provinciaRepository.save(provincia);
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        
    }
    
}
