package com.practica.rick_morty.prueba.beans;

import lombok.Data;

@Data
public class CharacterInfo {
    private int id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private Origin origin;
    private String image;
}
