package com.jorge.api.service.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.api.dto.PersonaDTO;
import com.jorge.api.entity.Ciudad;
import com.jorge.api.entity.Persona;
import com.jorge.api.exception.EntityNotFoundException;
import com.jorge.api.mapper.PersonaMapper;
import com.jorge.api.repository.PersonaRepository;
import com.jorge.api.service.CiudadService;
import com.jorge.api.service.PersonaService;

@Service
public class PersonaServiceImplement implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;
    private final CiudadService ciudadService;

    @Autowired
    public PersonaServiceImplement(PersonaRepository personaRepository, PersonaMapper personaMapper, CiudadService ciudadService){
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
        this.ciudadService = ciudadService;
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findByDeleted(Boolean.FALSE);
    }

    @Override
    public void create(PersonaDTO personaDTO) {
        try {
            Persona persona = personaMapper.mapperPersonaDTO2Persona(personaDTO);
            Ciudad ciudad = ciudadService.findById(personaDTO.getCiudadId());
            persona.setCiudad(ciudad);
            persona.setDeleted(Boolean.FALSE);
            personaRepository.save(persona);
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }        
    }

    @Override
    public void delete(Long id) {
        try {
            Persona persona = findById(id);
            persona.setDeleted(Boolean.TRUE);
            personaRepository.save(persona);
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Persona findById(Long id) throws EntityNotFoundException {
        Optional<Persona> persona = personaRepository.findByIdAndDeleted(id, Boolean.FALSE);
        if (persona.isPresent()) {
            return persona.get();
        } else {
            throw new EntityNotFoundException("Not found Persona entity with ID: " + id);
        }
    }
    
}
