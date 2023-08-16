package com.practica.rick_morty.prueba.services;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.beans.RMApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CharacterServiceImpl implements  CharacterService {

    RestTemplate restTemplate;

    @Autowired
    public CharacterServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
        return null;
    }
}
