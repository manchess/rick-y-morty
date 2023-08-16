package com.practica.rick_morty.prueba.services;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.beans.RMApi;

import java.util.Optional;

public interface CharacterService {
    RMApi getCharactersAPI(Integer page);

    CharacterInfo getCharacterAPIById(Integer id);
}
