package com.jorge.api.repository;

import java.util.List;
import java.util.Optional;

import com.jorge.api.entity.Ciudad;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Long> {
    List<Ciudad> findByDeleted(Boolean deleted);
    Optional<Ciudad> findByIdAndDeleted(Long id, Boolean deleted);
}
