package com.practica.rick_morty.prueba.controllers;

import com.practica.rick_morty.prueba.beans.RMApi;
import com.practica.rick_morty.prueba.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rm/")
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping("inicio")
    public RMApi getApiCharacters() {
        return service.getCharactersAPI();
    }


    @GetMapping("/characters")
    public void getCharacters() {


    }

    @GetMapping("/characters/{id}")
    public void getCharacterById(@PathVariable Integer id) {

    }
}
