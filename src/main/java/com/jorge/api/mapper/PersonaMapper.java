package com.jorge.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.jorge.api.dto.PersonaDTO;
import com.jorge.api.entity.Persona;

import org.springframework.stereotype.Service;


@Service
public class PersonaMapper {

  public Persona mapperPersonaDTO2Persona(PersonaDTO personaDTO) {
    Persona persona = new Persona();
    persona.setId(personaDTO.getId());
    persona.setName(personaDTO.getName());
    persona.setLastname(personaDTO.getLastname());
    persona.setDni(personaDTO.getDni());
    persona.setBirthday(personaDTO.getBirthday());
    return persona;
  }

  public PersonaDTO mapperPersona2PersonaDTO(Persona persona) {
    PersonaDTO personaDTO = new PersonaDTO();
    personaDTO.setId(persona.getId());
    personaDTO.setName(persona.getName());
    personaDTO.setLastname(persona.getLastname());
    personaDTO.setDni(persona.getDni());
    personaDTO.setBirthday(persona.getBirthday());
    personaDTO.setCiudadId(persona.getCiudad().getId());
    personaDTO.setCiudadNombre(persona.getCiudad().getName());
    return personaDTO;
  }

  public List<PersonaDTO> mapperListPersona2ListPersonaDTO(List<Persona> personas){
    return personas.stream().map(this::mapperPersona2PersonaDTO).collect(Collectors.toList());
  }
}
