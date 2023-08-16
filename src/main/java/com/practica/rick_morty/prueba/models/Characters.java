package com.practica.rick_morty.prueba.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Characters {
    @Id
    private Integer id;

    private String name;
    private String status;
    private String species;
    private String gender;
    private String origin;
    private String image;
}
