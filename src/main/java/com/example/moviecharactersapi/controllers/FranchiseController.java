package com.example.moviecharactersapi.controllers;

import com.example.moviecharactersapi.entities.Franchise;
import com.example.moviecharactersapi.services.service_interfaces.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/franchises")
public class FranchiseController {
    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }


    @GetMapping
    public ResponseEntity findAll(){ return ResponseEntity.ok(franchiseService.findAll()); }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){ return ResponseEntity.ok(franchiseService.findById(id)); }

    @PostMapping
    public ResponseEntity add(@RequestBody Franchise entity) throws URISyntaxException {
        franchiseService.add(entity);
        URI uri = new URI("api/v1/franchises" + entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @PostMapping
    public ResponseEntity update(@RequestBody Franchise entity, @PathVariable int id){
        if(id != entity.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(entity);
        return ResponseEntity.noContent().build();
    }

}
