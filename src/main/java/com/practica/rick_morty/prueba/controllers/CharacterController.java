package com.practica.rick_morty.prueba.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rick-and-morty/")
public class CharacterController {

    @GetMapping("RMApiCharacters")
    public void getApiCharacters() {

    }

    @GetMapping("/characters")
    public void getCharacters() {

    }

    @GetMapping("/characters/{id}")
    public void getCharacterById(@PathVariable Integer id) {

    }
}
