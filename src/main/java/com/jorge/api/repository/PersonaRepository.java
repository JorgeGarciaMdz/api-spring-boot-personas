package com.jorge.api.repository;

import java.util.List;
import java.util.Optional;

import com.jorge.api.entity.Persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    List<Persona> findByDeleted(Boolean deleted);
    Optional<Persona> findByIdAndDeleted(Long id, Boolean deleted);
}
