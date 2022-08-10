package com.jorge.api.service;

import java.util.List;

import com.jorge.api.entity.Parentesco;
import com.jorge.api.exception.EntityNotFoundException;

public interface ParentescoService {
  public List<Parentesco> findAll();
  public void create(Parentesco parentesco);
  public Parentesco findById(Long id) throws EntityNotFoundException;
  public void delete(Long id);
}
