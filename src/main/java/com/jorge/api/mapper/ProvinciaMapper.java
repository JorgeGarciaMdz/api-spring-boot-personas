package com.jorge.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.jorge.api.dto.ProvinciaDTO;
import com.jorge.api.entity.Provincia;

import org.springframework.stereotype.Service;


@Service
public class ProvinciaMapper {
  
  public Provincia mapperProvinciaDTO2Provincia(ProvinciaDTO provinciaDTO){
    Provincia provincia = new Provincia();
    provincia.setId(provinciaDTO.getId());
    provincia.setName(provinciaDTO.getName().toUpperCase());
    provincia.setDeleted(Boolean.FALSE);
    return provincia;
  }

  public ProvinciaDTO mapperProvincia2ProvinciaDTO(Provincia provincia){
    ProvinciaDTO p = new ProvinciaDTO();
    p.setId(provincia.getId());
    p.setName(provincia.getName());
    return p;
  }

  public List<ProvinciaDTO> mapperListProvincia2ListProvinciaDTO(List<Provincia> provincias){
    return provincias.stream().map(this::mapperProvincia2ProvinciaDTO).collect(Collectors.toList());
  }
}
