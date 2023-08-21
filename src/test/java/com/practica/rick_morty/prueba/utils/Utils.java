package com.practica.rick_morty.prueba.utils;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.beans.Origin;
import com.practica.rick_morty.prueba.models.Characters;

import java.util.Optional;

public class Utils {

    public static final Integer CHARACTER_ID = 1;
    public static final String CHARACTER_NAME = "Rick Sanchez";
    public static final String CHARACTER_STATUS = "Alive";
    public static final String CHARACTER_SPECIES = "Human";
    public static final String CHARACTER_GENDER = "Male";
    public static final String CHARACTER_ORIGIN = "Earth";
    public static final String CHARACTER_IMAGE = "https://rickandmortyapi.com/api/character/avatar/1.jpeg";

    public static Characters createEntity() {
        Characters newEntity = new Characters();

        newEntity.setId(CHARACTER_ID);
        newEntity.setName(CHARACTER_NAME);
        newEntity.setStatus(CHARACTER_STATUS);
        newEntity.setSpecies(CHARACTER_SPECIES);
        newEntity.setGender(CHARACTER_GENDER);
        newEntity.setOrigin(CHARACTER_ORIGIN);
        newEntity.setImage(CHARACTER_IMAGE);

        return newEntity;
    }

    public static CharacterInfo createCharacterInfo() {

        CharacterInfo newCharacter = new CharacterInfo();

        Origin origin = new Origin();
        origin.setName(CHARACTER_ORIGIN);


        newCharacter.setId(CHARACTER_ID);
        newCharacter.setName(CHARACTER_NAME);
        newCharacter.setStatus(CHARACTER_STATUS);
        newCharacter.setSpecies(CHARACTER_SPECIES);
        newCharacter.setGender(CHARACTER_GENDER);
        newCharacter.setOrigin(origin);
        newCharacter.setImage(CHARACTER_IMAGE);

        return newCharacter;
    }

    public static Characters toEntity(CharacterInfo character) {
        Characters entity = new Characters();

        entity.setId(character.getId());
        entity.setName(character.getName());
        entity.setStatus(character.getStatus());
        entity.setSpecies(character.getSpecies());
        entity.setGender(character.getGender());
        entity.setOrigin(character.getOrigin().getName());
        entity.setImage(character.getImage());

        return entity;
    }
}
