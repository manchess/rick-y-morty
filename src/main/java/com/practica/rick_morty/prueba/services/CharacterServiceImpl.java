package com.practica.rick_morty.prueba.services;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.beans.Origin;
import com.practica.rick_morty.prueba.beans.RMApi;
import com.practica.rick_morty.prueba.exceptions.CharacterException;
import com.practica.rick_morty.prueba.models.Characters;
import com.practica.rick_morty.prueba.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        ResponseEntity<RMApi> response = restTemplate.getForEntity(CHARACTERS_URL, RMApi.class);

        return response.getBody();
    }

    @Override
    public CharacterInfo getCharacterAPIById(Integer id) {
        final String CHARACTER_URL = "https://rickandmortyapi.com/api/character/" + id;

        ResponseEntity<CharacterInfo> response = restTemplate.getForEntity(CHARACTER_URL, CharacterInfo.class);

        return response.getBody();
    }

    @Override
    public CharacterInfo saveCharacterById(Integer id) {
        CharacterInfo character;
        Optional<Characters> entity = repository.findById(id);
        final String EXCEPTION_MSG = "The character you are trying to create already exists";

        // If it exists, we notify that it cannot be created
        if (entity.isPresent()) {
            throw new CharacterException(EXCEPTION_MSG);
        }

        // Look for the character of the API that corresponds to the id and save it
        character = getCharacterAPIById(id);
        repository.save(toEntity(character));

        return character;
    }

    @Override
    public CharacterInfo findCharacterById(Integer id) {
        Optional<Characters> entity = repository.findById(id);
        final String EXCEPTION_MSG = "Character not found";

        if (entity.isPresent()) {
            return toBean(entity.get());
        }

        throw new CharacterException(EXCEPTION_MSG);
    }

    @Override
    public List<CharacterInfo> getCharacters(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Characters> pageCharacters = repository.findAll(pageable);

        List<Characters> entities = pageCharacters.getContent();

        return entities.stream().map(this::toBean).collect(Collectors.toList());
    }

    @Override
    public String updateCharacterById(CharacterInfo characterToUpdate) {
        Characters characterFromDB = toEntity(findCharacterById(characterToUpdate.getId()));

        characterFromDB.setName(characterToUpdate.getName());
        characterFromDB.setSpecies(characterToUpdate.getSpecies());
        characterFromDB.setGender(characterToUpdate.getGender());
        characterFromDB.setOrigin(characterToUpdate.getOrigin().getName());
        characterFromDB.setImage(characterToUpdate.getImage());

        repository.save(characterFromDB);

        return "OK";
    }

    @Override
    public String deleteCharacterById(int id) {
        Characters characterToDele = toEntity(findCharacterById(id));

        repository.delete(characterToDele);

        return "OK";
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

    private CharacterInfo toBean(Characters entity) {
        CharacterInfo character = new CharacterInfo();
        Origin origin = new Origin();
        origin.setName(entity.getOrigin());

        character.setId(entity.getId());
        character.setName(entity.getName());
        character.setStatus(entity.getStatus());
        character.setSpecies(entity.getSpecies());
        character.setGender(entity.getGender());
        character.setOrigin(origin);
        character.setImage(entity.getImage());

        return character;
    }
}
