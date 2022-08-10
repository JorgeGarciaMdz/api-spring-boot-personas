package com.jorge.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CiudadDTO {
  
  private Long id;

  @NotNull(message = "Ciudad name cannot be Null")
  @NotEmpty(message = "Ciudad name cannot be Empty")
  @Size(min = 3, max = 150, message = "Ciudad name size must be between 3 and 150")
  private String name;

  @NotNull
  private Long provinciaId;

  private String provinciaName;
}
