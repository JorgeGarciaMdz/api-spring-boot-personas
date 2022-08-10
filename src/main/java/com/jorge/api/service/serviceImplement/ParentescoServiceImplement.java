package com.jorge.api.service.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.api.entity.Parentesco;
import com.jorge.api.exception.EntityNotFoundException;
import com.jorge.api.repository.ParentescoRepository;
import com.jorge.api.service.ParentescoService;

@Service
public class ParentescoServiceImplement implements ParentescoService {

  private final ParentescoRepository parentescoRepository;

  @Autowired
  public ParentescoServiceImplement(ParentescoRepository parentescoRepository) {
    this.parentescoRepository = parentescoRepository;
  }

  @Override
  public List<Parentesco> findAll() {
    return parentescoRepository.findByDeleted(Boolean.FALSE);
  }

  @Override
  public void create(Parentesco parentesco) {
    parentesco.setDeleted(Boolean.FALSE);
    parentescoRepository.save(parentesco);
  }

  @Override
  public Parentesco findById(Long id) throws EntityNotFoundException {
    Optional<Parentesco> parentesco = parentescoRepository.findByIdAndDeleted(id, Boolean.FALSE);
    if (parentesco.isPresent())
      return parentesco.get();
    else
      throw new EntityNotFoundException("Parentesco entity not found with ID: " + id);
  }

  @Override
  public void delete(Long id) {
    try {
      Parentesco parentesco = findById(id);
      parentesco.setDeleted(Boolean.TRUE);
      parentescoRepository.save(parentesco);

    } catch (EntityNotFoundException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }    
  }

}
