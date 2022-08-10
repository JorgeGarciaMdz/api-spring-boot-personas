package com.jorge.api.service.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.api.dto.CiudadDTO;
import com.jorge.api.entity.Ciudad;
import com.jorge.api.entity.Provincia;
import com.jorge.api.exception.EntityNotFoundException;
import com.jorge.api.mapper.CiudadMapper;
import com.jorge.api.repository.CiudadRepository;
import com.jorge.api.service.CiudadService;
import com.jorge.api.service.ProvinciaService;

@Service
public class CiudadServiceImplement implements CiudadService {

    private final CiudadRepository ciudadRepository;
    private final ProvinciaService provinciaService;
    private final CiudadMapper ciudadMapper;

    @Autowired
    public CiudadServiceImplement(CiudadRepository ciudadRepository, ProvinciaService provinciaService,
            CiudadMapper ciudadMapper) {
        this.ciudadRepository = ciudadRepository;
        this.provinciaService = provinciaService;
        this.ciudadMapper = ciudadMapper;
    }

    @Override
    public List<Ciudad> findAll() {
        return ciudadRepository.findByDeleted(Boolean.FALSE);
    }

    @Override
    public Ciudad findById(Long id) throws EntityNotFoundException {
        Optional<Ciudad> ciudad = ciudadRepository.findByIdAndDeleted(id, Boolean.FALSE);
        if (ciudad.isPresent()) {
            return ciudad.get();
        } else
            throw new EntityNotFoundException("Not found Ciudad entity with ID: " + id);
    }

    @Override
    public void create(CiudadDTO ciudadDTO){
        try {
            Provincia provincia = provinciaService.findById(ciudadDTO.getProvinciaId());
            Ciudad ciudad = ciudadMapper.mapperCiudadDTO2Ciudad(ciudadDTO);
            ciudad.setProvincia(provincia);
            ciudadRepository.save(ciudad);
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Ciudad ciudad = findById(id);
            ciudad.setDeleted(Boolean.TRUE);
            ciudadRepository.save(ciudad);
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
