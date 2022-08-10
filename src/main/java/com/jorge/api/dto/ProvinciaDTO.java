package com.jorge.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProvinciaDTO {
  private Long id;

  @NotNull(message = "Provincia name cannot be Null")
  @NotEmpty(message = "Provincia name cannot be Empty")
  @Size(min = 3, max = 150, message = "Provincia name size must be between 3 and 150")
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Id: " + this.id + ", name: " + this.name;
  }
}
