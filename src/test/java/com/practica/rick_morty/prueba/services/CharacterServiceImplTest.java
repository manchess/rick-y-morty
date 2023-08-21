package com.practica.rick_morty.prueba.services;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.models.Characters;
import com.practica.rick_morty.prueba.repository.CharacterRepository;
import com.practica.rick_morty.prueba.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

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
        //Optional<Characters> rickSanchez = Optional.of(Utils.createEntity());
        Optional<Characters> rickSanchez = Optional.empty();
        CharacterInfo characterInfo = Utils.createCharacterInfo();

//        when(spyService.getCharacterAPIById(anyInt())).thenReturn(characterInfo);
        doReturn(characterInfo).when(spyService).getCharacterAPIById(anyInt());
        when(mockRepository.findById(anyInt())).thenReturn(rickSanchez);
        when(mockRepository.save(Utils.toEntity(characterInfo))).thenReturn(Utils.toEntity(characterInfo));


        // Act
        CharacterInfo response = spyService.saveCharacterById(1);

        // Asserts
        assertEquals(characterInfo, response);

    }

    @Test
    void findCharacterById() {
    }

    @Test
    void getCharacters() {
    }

    @Test
    void updateCharacterById() {
    }

    @Test
    void deleteCharacterById() {
    }
}