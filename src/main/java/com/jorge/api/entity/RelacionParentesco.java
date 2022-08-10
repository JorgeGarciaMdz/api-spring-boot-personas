package com.jorge.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "relacion_parentesco")
@Data
public class RelacionParentesco {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "DESDE_RELACION", referencedColumnName = "ID")
  private Persona personaOne;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "HASTA_RELACION", referencedColumnName = "ID")
  private Persona personaTwo;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "PARENTESCO_ID", referencedColumnName = "ID")
  private Parentesco parentesco;

  private Boolean deleted;
}
