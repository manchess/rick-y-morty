package com.practica.rick_morty.prueba.controllers;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.beans.RMApi;
import com.practica.rick_morty.prueba.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rm/")
public class CharacterController {

    @Autowired
    private CharacterService service;

    // External endpoints to consume the R&M API
    @GetMapping("ext/character")
    public RMApi getApiCharacters(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        return service.getCharactersAPI(page);
    }

    @GetMapping("ext/character/{id}")
    public CharacterInfo getApiCharacterById(@PathVariable Integer id) {
        return service.getCharacterAPIById(id);
    }



    // Local endpoints to consume the API
    @GetMapping("/character")
    public List<CharacterInfo> getCharacters(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "3") int size
    ) {
        return service.getCharacters(page, size);
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<CharacterInfo> getCharacterById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findCharacterById(id));
    }

    @PostMapping("/character/{id}")
    public ResponseEntity<CharacterInfo> saveCharacter(@PathVariable Integer id) {
        return ResponseEntity.ok(service.saveCharacterById(id));
    }
}
