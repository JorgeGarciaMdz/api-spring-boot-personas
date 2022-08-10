package com.jorge.api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "provincia")
@Entity
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String name;

    @OneToMany(mappedBy = "provincia")
    private Set<Ciudad> cities = new HashSet<Ciudad>();

    @Column(name = "DELETED")
    private Boolean deleted;

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

    public Set<Ciudad> getCities() {
        return cities;
    }

    public void setCities(Set<Ciudad> cities) {
        this.cities = cities;
    }

    /*public void addCities(Ciudad ciudad){
        cities.add(ciudad);
    } */

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", name: " + this.name + ", deleted: " + this.deleted + ", count cities: "
                + this.cities.size();
    }
}
