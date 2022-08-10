package com.jorge.api.service;

import java.util.List;

import com.jorge.api.dto.RelacionParentescoDTO;
import com.jorge.api.entity.RelacionParentesco;
import com.jorge.api.exception.EntityNotFoundException;

public interface RelacionParentescoService {
  
  List<RelacionParentesco> findAll();
  RelacionParentesco findById(Long id) throws EntityNotFoundException;
  void save(RelacionParentescoDTO relacionParentescoDTO);
  void delete(Long id);
}
