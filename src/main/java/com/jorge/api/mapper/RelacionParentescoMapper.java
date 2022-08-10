package com.jorge.api.mapper;

import com.jorge.api.dto.RelacionParentescoDTO;
import com.jorge.api.entity.RelacionParentesco;

import org.springframework.stereotype.Service;

@Service
public class RelacionParentescoMapper {

  public RelacionParentesco mapperRelacionParentescoDTO2RelacionParentesco(
      RelacionParentescoDTO relacionParentescoDTO) {
    RelacionParentesco relacionParentesco = new RelacionParentesco();
    relacionParentesco.setId(relacionParentescoDTO.getId());
    return relacionParentesco;
  }

  public RelacionParentescoDTO mapperRelacionParentescto2RelacionParentescoDTO(RelacionParentesco relacionParentesco) {
    return RelacionParentescoDTO.builder().id(relacionParentesco.getId())
        .personaOne(relacionParentesco.getPersonaOne().getId()).personaTwo(relacionParentesco.getPersonaTwo().getId())
        .parentescoId(relacionParentesco.getParentesco().getId()).build();
  }
}
