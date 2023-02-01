package com.example.moviecharactersapi.controllers;

import com.example.moviecharactersapi.mappers.CharacterMapper;
import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.dto.character.CharacterDTO;
import com.example.moviecharactersapi.services.character.CharacterService;
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
@RequestMapping(path = "api/v1/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @Operation(summary = "Gets all the Characters")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",
                            description = "Success",
                            content = {@Content( mediaType = "application/json",
                                array = @ArraySchema( schema = @Schema(implementation = CharacterDTO.class)))})
    })
    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
                characterMapper.characterToCharacterDTO(
                        characterService.findAll()
                ));
    }

    @Operation(summary = "Finds the Character with the specific id")
    @ApiResponses(value = {
            @ApiResponse( responseCode =  "200",
                            description = "Success",
                            content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class))}),
            @ApiResponse( responseCode = "404",
                            description = "Character does not exist with supplied id",
                            content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))})
    @GetMapping("{id}")
    public ResponseEntity findAllById(@PathVariable int id){
        return ResponseEntity.ok(
                characterMapper.characterToCharacterDTO(
                        characterService.findById(id)) );
    }

    @Operation(summary = "Adds a new Character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Created",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity add(@RequestBody Character entity) throws URISyntaxException {
        //add character
        characterMapper.characterToCharacterDTO(
                characterService.add(entity)); //do we need to use characterPostDTO?
        URI uri = new URI("api/v1/characters/" + entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Updates a Character with a specific id")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "204",
                            description = "Success",
                            content = { @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CharacterDTO.class))}),
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
    public ResponseEntity update(@RequestBody Character entity, @PathVariable int id){
        if(id != entity.getId())
            return  ResponseEntity.badRequest().build();
        characterService.update(entity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (id != characterMapper.characterToCharacterDTO(characterService.findById(id)).getId())
            return ResponseEntity.badRequest().build();
        //characterMapper.characterToCharacterDTO(characterService.findById(id)).setMovies(null);
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
