package com.jorge.api.repository;

import java.util.List;
import java.util.Optional;

import com.jorge.api.entity.Provincia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends CrudRepository<Provincia, Long> {
    List<Provincia> findByDeleted(Boolean deleted);
    Optional<Provincia> findByIdAndDeleted(Long id, Boolean deleted);
}
