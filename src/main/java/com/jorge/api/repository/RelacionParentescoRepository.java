package com.jorge.api.repository;

import java.util.List;
import java.util.Optional;

import com.jorge.api.entity.RelacionParentesco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RelacionParentescoRepository extends CrudRepository<RelacionParentesco, Long> {
  
  List<RelacionParentesco> findByDeleted(Boolean deleted);
  Optional<RelacionParentesco> findByIdAndDeleted(Long id, Boolean deleted);
}
