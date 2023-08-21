package com.practica.rick_morty.prueba.services;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.exceptions.CharacterException;
import com.practica.rick_morty.prueba.models.Characters;
import com.practica.rick_morty.prueba.repository.CharacterRepository;
import com.practica.rick_morty.prueba.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class CharacterServiceImplTest {

    CharacterServiceImpl spyService;
    RestTemplate mockRestTemplate;
    CharacterRepository mockRepository;

    @BeforeEach
    void setUp() {
        mockRestTemplate = mock(RestTemplate.class);
        mockRepository = mock(CharacterRepository.class);

        spyService = spy(new CharacterServiceImpl(mockRestTemplate, mockRepository));
    }

    @Test
    void saveCharacterById() {
        // Arrange
        Optional<Characters> rickSanchez = Optional.empty();
        CharacterInfo characterInfo = Utils.createCharacterInfo();

        doReturn(characterInfo).when(spyService).getCharacterAPIById(anyInt());
        when(mockRepository.findById(anyInt())).thenReturn(rickSanchez);
        when(mockRepository.save(Utils.toEntity(characterInfo))).thenReturn(Utils.toEntity(characterInfo));

        // Act
        CharacterInfo response = spyService.saveCharacterById(1);

        // Asserts
        assertEquals(characterInfo, response);
    }

    // Terminando estos test
    @Test
    void findCharacterById() {
        // Arrange
        Optional<Characters> noCharacter = Optional.empty();
        when(mockRepository.findById(anyInt())).thenReturn(noCharacter);

        // Act & Asserts - We assume that the character does not exist in the DB, then it throws an exception
        assertThrows(CharacterException.class, () -> spyService.findCharacterById(2));

    }

    @Test
    void getCharacters() {
        // Arrange
        Characters rickSanchez = Utils.createEntity();
        List arrCharacters = Arrays.asList(rickSanchez);

        Page<Characters> characters = new PageImpl<>(arrCharacters);

        when(mockRepository.findAll(any(Pageable.class))).thenReturn(characters);

        // Act
        List<CharacterInfo> response = spyService.getCharacters(0, 2);

        // Asserts
        assertEquals(1, response.size());
        assertEquals(Utils.CHARACTER_NAME, response.get(0).getName());

    }

    @Test
    void updateCharacterById() {
    }

    @Test
    void deleteCharacterById() {
    }
}