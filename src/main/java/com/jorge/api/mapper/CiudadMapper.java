package com.jorge.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.jorge.api.dto.CiudadDTO;
import com.jorge.api.entity.Ciudad;

import org.springframework.stereotype.Service;

@Service
public class CiudadMapper {
  
  public Ciudad mapperCiudadDTO2Ciudad(CiudadDTO ciudadDTO){
    Ciudad ciudad = new Ciudad();
    ciudad.setId(ciudadDTO.getId());
    ciudad.setName(ciudadDTO.getName().toUpperCase());
    return ciudad;
  }

  public CiudadDTO mapperCiudad2CiudadDTO(Ciudad ciudad){
    CiudadDTO ciudadDTO = new CiudadDTO();
    ciudadDTO.setId(ciudad.getId());
    ciudadDTO.setName(ciudad.getName());
    ciudadDTO.setProvinciaId(ciudad.getProvincia().getId());
    ciudadDTO.setProvinciaName(ciudad.getProvincia().getName());
    return ciudadDTO;
  }

  public List<CiudadDTO> mapperListCiudad2ListCiudadDTO(List<Ciudad> ciudades){
    return ciudades.stream().map(this::mapperCiudad2CiudadDTO).collect(Collectors.toList());
  }
}
