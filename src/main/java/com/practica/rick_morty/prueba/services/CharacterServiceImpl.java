package com.practica.rick_morty.prueba.services;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.beans.RMApi;
import com.practica.rick_morty.prueba.exceptions.CharacterExistException;
import com.practica.rick_morty.prueba.models.Characters;
import com.practica.rick_morty.prueba.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements  CharacterService {

    RestTemplate restTemplate;
    CharacterRepository repository;

    @Autowired
    public CharacterServiceImpl(RestTemplate restTemplate, CharacterRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    @Override
    public RMApi getCharactersAPI(Integer page) {
        final String CHARACTERS_URL = "https://rickandmortyapi.com/api/character?page=" + page;

        try {
            ResponseEntity<RMApi> response = restTemplate.getForEntity(CHARACTERS_URL, RMApi.class);
            return response.getBody();
        } catch (RestClientException e) {
            throw e;
        }
    }

    @Override
    public CharacterInfo getCharacterAPIById(Integer id) {
        final String CHARACTER_URL = "https://rickandmortyapi.com/api/character/" + id;

        try {
            ResponseEntity<CharacterInfo> response = restTemplate.getForEntity(CHARACTER_URL, CharacterInfo.class);
            return response.getBody();
        } catch (RestClientException e) {
            throw e;
        }
    }

    @Override
    public CharacterInfo saveCharacterById(Integer id) {
        CharacterInfo character;
        Optional<Characters> entity = repository.findById(id);
        final String EXCEPTION_MSG = "The character you are trying to create already exists";

        // If it exists, we notify that it cannot be created
        if (entity.isPresent())
        {
            throw new CharacterExistException(EXCEPTION_MSG);
        }

        // Look for the character of the API that corresponds to the id and save it
        character = getCharacterAPIById(id);
        repository.save(toEntity(character));
        
        return character;
    }

    private Characters toEntity(CharacterInfo character) {
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
