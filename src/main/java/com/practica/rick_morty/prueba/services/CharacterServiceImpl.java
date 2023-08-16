package com.practica.rick_morty.prueba.services;

import com.practica.rick_morty.prueba.beans.RMApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterServiceImpl implements  CharacterService {

    RestTemplate restTemplate;

    @Autowired
    public CharacterServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RMApi getCharactersAPI() {
        final String CHARACTERS_URL = "https://rickandmortyapi.com/api/character";

        try {
            ResponseEntity<RMApi> response = restTemplate.getForEntity(CHARACTERS_URL, RMApi.class);
            return response.getBody();
        } catch (RestClientException e) {
            // TODO: Manejar la excepcion
            return null;
        }
    }
}
