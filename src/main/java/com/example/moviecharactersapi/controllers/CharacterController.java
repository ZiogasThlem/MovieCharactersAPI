package com.example.moviecharactersapi.controllers;

import com.example.moviecharactersapi.entities.Character;
import com.example.moviecharactersapi.services.service_interfaces.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/characters")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity findAll(){ return ResponseEntity.ok(characterService.findAll()); }

    @GetMapping("{id}")
    public ResponseEntity findAllById(@PathVariable int id){ return ResponseEntity.ok(characterService.findById(id)); }

    @PostMapping
    public ResponseEntity add(@RequestBody Character entity) throws URISyntaxException {
        //add character
        characterService.add(entity);
        URI uri = new URI("api/v1/characters/" + entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("{id}")
    public ResponseEntity update(@RequestBody Character entity, @PathVariable int id){
        if(id != entity.getId())
            return  ResponseEntity.badRequest().build();
        characterService.update(entity);
        return ResponseEntity.noContent().build();
    }
}
