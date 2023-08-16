package com.practica.rick_morty.prueba.beans;

import lombok.Data;

import java.util.List;

@Data
public class RMApi {
    private Info info;
    private List<CharacterInfo> results;
}
