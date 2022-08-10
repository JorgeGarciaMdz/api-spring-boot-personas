package com.jorge.api.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PersonaDTO {
  
  private Long id;

  @NotNull(message = "Persona name cannot be Null")
  @NotEmpty(message = "Persona name cannot be Empty")
  @Size(min = 3, max = 150, message = "Persona name size must be between 3 and 150")
  private String name;

  @NotNull(message = "Persona Last Name cannot be Null")
  @NotEmpty(message = "Persona Last Name  cannot be Empty")
  @Size(min = 3, max = 150, message = "Persona Last  name size must be between 3 and 150")
  private String lastname;

  @NotNull(message = "Persona DNI cannot be Null")
  @Min(value = 100)
  private Integer dni;

  @NotNull(message = "Persona Birthday cannot be Null")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthday;

  @NotNull(message = "Persona Ciudad cannot be Null")
  private Long ciudadId;

  private String ciudadNombre;
}
