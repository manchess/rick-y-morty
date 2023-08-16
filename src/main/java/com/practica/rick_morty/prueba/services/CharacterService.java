package com.practica.rick_morty.prueba.services;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.beans.RMApi;

import java.util.List;

public interface CharacterService {
    RMApi getCharactersAPI(Integer page);

    CharacterInfo getCharacterAPIById(Integer id);

    CharacterInfo saveCharacterById(Integer id);

    CharacterInfo findCharacterById(Integer id);

    List<CharacterInfo> getCharacters(int page, int size);
}
