package com.practica.rick_morty.prueba.controllers;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.beans.RMApi;
import com.practica.rick_morty.prueba.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rm/")
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping("character")
    public RMApi getApiCharacters(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        return service.getCharactersAPI(page);
    }

    @GetMapping("character/{id}")
    public CharacterInfo getApiCharacterById(@PathVariable Integer id) {
        return service.getCharacterAPIById(id);
    }


    @GetMapping("/characters")
    public void getCharacters() {


    }

    @GetMapping("/characters/{id}")
    public void getCharacterById(@PathVariable Integer id) {

    }

    @PostMapping("/character/{id}")
    public ResponseEntity<CharacterInfo> saveCharacter(@PathVariable Integer id) {
        return ResponseEntity.ok(service.saveCharacterById(id));
    }
}
