package com.jorge.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RelacionParentescoDTO {
  
  private Long id;
  private Long personaOne;
  private Long personaTwo;
  private Long parentescoId;
}
