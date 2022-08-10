package com.jorge.api.service.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.api.dto.RelacionParentescoDTO;
import com.jorge.api.entity.Parentesco;
import com.jorge.api.entity.Persona;
import com.jorge.api.entity.RelacionParentesco;
import com.jorge.api.exception.EntityNotFoundException;
import com.jorge.api.mapper.RelacionParentescoMapper;
import com.jorge.api.repository.RelacionParentescoRepository;
import com.jorge.api.service.ParentescoService;
import com.jorge.api.service.PersonaService;
import com.jorge.api.service.RelacionParentescoService;

@Service
public class RelacionParentescoServiceImplement implements RelacionParentescoService {

  private final RelacionParentescoRepository relacionParentescoRepository;
  private final PersonaService personaService;
  private final ParentescoService parentescoService;
  private final RelacionParentescoMapper relacionParentescoMapper;

  @Autowired
  public RelacionParentescoServiceImplement(RelacionParentescoRepository relacionParentescoRepository,
      PersonaService personaService, ParentescoService parentescoService,
      RelacionParentescoMapper relacionParentescoMapper) {
    this.relacionParentescoRepository = relacionParentescoRepository;
    this.personaService = personaService;
    this.parentescoService = parentescoService;
    this.relacionParentescoMapper = relacionParentescoMapper;
  }

  @Override
  public List<RelacionParentesco> findAll() {
    return relacionParentescoRepository.findByDeleted(Boolean.FALSE);
  }

  @Override
  public RelacionParentesco findById(Long id) throws EntityNotFoundException {
    Optional<RelacionParentesco> relacionParentesco = relacionParentescoRepository.findByIdAndDeleted(id,
        Boolean.FALSE);
    if (relacionParentesco.isPresent())
      return relacionParentesco.get();
    else
      throw new EntityNotFoundException("Entity RelacionParentesco not found with ID: " + id);
  }

  @Override
  public void save(RelacionParentescoDTO relacionParentescoDTO) {
    try {
      Persona personaOne = personaService.findById(relacionParentescoDTO.getPersonaOne());
      Persona personaTwo = personaService.findById(relacionParentescoDTO.getPersonaTwo());
      Parentesco parentesco = parentescoService.findById(relacionParentescoDTO.getParentescoId());
      RelacionParentesco relacionParentesco = relacionParentescoMapper.mapperRelacionParentescoDTO2RelacionParentesco(relacionParentescoDTO);
      relacionParentesco.setPersonaOne(personaOne);
      relacionParentesco.setPersonaTwo(personaTwo);
      relacionParentesco.setParentesco(parentesco);
      relacionParentesco.setDeleted(Boolean.FALSE);
      relacionParentescoRepository.save(relacionParentesco);
    } catch (EntityNotFoundException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Long id) {
    try {
      RelacionParentesco relacionParentesco = findById(id);
      relacionParentesco.setDeleted(Boolean.TRUE);
      relacionParentescoRepository.save(relacionParentesco);
    } catch (EntityNotFoundException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    
  }

}
