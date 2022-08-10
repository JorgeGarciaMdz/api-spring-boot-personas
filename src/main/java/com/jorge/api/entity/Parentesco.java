package com.jorge.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "parentesco")
public class Parentesco {
  
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @NotNull(message = " Description cannot be Null")
  @NotEmpty(message = "Description cannot be Empty")
  @Size(min = 3, max = 150, message = "Description size must be between 3 and 50")
  @Column(name = "DESCRIPCION")
  private String description;

  @Column(name = "DELETED")
  private Boolean deleted;
}
