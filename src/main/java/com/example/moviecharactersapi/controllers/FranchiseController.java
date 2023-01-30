package com.example.moviecharactersapi.controllers;

import com.example.moviecharactersapi.models.Franchise;
import com.example.moviecharactersapi.models.dto.character.CharacterDTO;
import com.example.moviecharactersapi.models.dto.franchise.FranchiseDTO;
import com.example.moviecharactersapi.services.franchise.FranchiseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/franchises")
public class FranchiseController {
    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }


    @Operation(summary = "Finds all the Franchises")
    @ApiResponses(value = {
            @ApiResponse( responseCode =  "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class))}),
    })
    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(franchiseService.findAll());
    }

    @Operation(summary = "Finds the Franchise with the specific id")
    @ApiResponses(value = {
            @ApiResponse( responseCode =  "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class))}),
            @ApiResponse( responseCode = "404",
                    description = "Franchise does not exist with supplied id",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))})
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(franchiseService.findById(id));
    }

    @Operation(summary = "Adds a new Franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Created",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity add(@RequestBody Franchise entity) throws URISyntaxException {
        //add franchise
        franchiseService.add(entity);
        //creating uri with
        URI uri = new URI("api/v1/franchises/" + entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Updates a Franchise with a specific id")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "204",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))}),
            @ApiResponse( responseCode = "404",
                    description = "Character not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))})
    })
    @PostMapping("{id}")
    public ResponseEntity update(@RequestBody Franchise entity, @PathVariable int id){
        if(id != entity.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(entity);
        return ResponseEntity.noContent().build();
    }

}
