package com.jorge.api.repository;

import java.util.List;
import java.util.Optional;

import com.jorge.api.entity.Parentesco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentescoRepository extends CrudRepository<Parentesco, Long> {
  
  List<Parentesco> findByDeleted(Boolean deleted);
  Optional<Parentesco> findByIdAndDeleted(Long id, Boolean deleted);
}
