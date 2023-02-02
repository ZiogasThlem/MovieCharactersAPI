package com.example.moviecharactersapi.controllers;

import com.example.moviecharactersapi.mappers.CharacterMapper;
import com.example.moviecharactersapi.mappers.FranchiseMapper;
import com.example.moviecharactersapi.mappers.MovieMapper;
import com.example.moviecharactersapi.models.Franchise;
import com.example.moviecharactersapi.models.dto.franchise.FranchiseDTO;
import com.example.moviecharactersapi.models.dto.franchise.FranchiseDeleteDTO;
import com.example.moviecharactersapi.models.dto.movie.MovieDTO;
import com.example.moviecharactersapi.services.franchise.FranchiseService;
import io.swagger.v3.oas.annotations.Operation;
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
    private final FranchiseMapper franchiseMapper;
    private final MovieMapper movieMapper;
    private final CharacterMapper characterMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper, MovieMapper movieMapper, CharacterMapper characterMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
        this.movieMapper = movieMapper;
        this.characterMapper = characterMapper;
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

        return ResponseEntity.ok(
                franchiseMapper.franchiseToFranchiseDTO(
                        franchiseService.findAll()));
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

        return ResponseEntity.ok(
                franchiseMapper.franchiseToFranchiseDTO(
                        franchiseService.findById(id)));
    }

    @Operation(summary = "Adds a new Franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Created",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity add(@RequestBody FranchiseDTO entity) throws URISyntaxException {
        //add franchise
        franchiseMapper.franchiseToFranchiseDTO(
                franchiseService.add(franchiseService.findById(entity.getId()))); //calls the franchise service to add the character by id
        //creating uri with this franchise id
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
    public ResponseEntity update(@RequestBody FranchiseDTO entity, @PathVariable int id){
        if(id != entity.getId()) //checks if the given id is same with the given franchise actual id
            return ResponseEntity.badRequest().build(); //if ids are different returns bad request response
        franchiseMapper.franchiseToFranchiseDTO(
                franchiseService.update(franchiseService.findById(entity.getId()))); //updates the franchise
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Gets all the movies in the Franchise with a specific id")
    @ApiResponses(value = {
            @ApiResponse( responseCode =  "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class))}),
            @ApiResponse( responseCode = "404",
                    description = "Franchise does not exist with supplied id",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))})
    @GetMapping("{id}/movies")
    public ResponseEntity getMovies(@PathVariable int id){

        return ResponseEntity.ok(
                movieMapper.movieToMovieDTO(
                        franchiseService.getMovies(id)));
    }

    @Operation(summary = "Gets all the characters of a Franchise with a specific id")
    @ApiResponses(value = {
            @ApiResponse( responseCode =  "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class))}),
            @ApiResponse( responseCode = "404",
                    description = "Franchise does not exist with supplied id",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))})
    @GetMapping("{id}/characters")
    public ResponseEntity getCharacters(@PathVariable int id){
        return ResponseEntity.ok(
               characterMapper.characterToCharacterDTO(
                       franchiseService.getCharacters(id)));}

    @Operation(summary = "Updates movies in a Franchise")
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
    @PutMapping("{id}/movies")
    public ResponseEntity updateMovies(@PathVariable int id, @RequestBody int[] moviesIds){
        franchiseService.updateMovies(id,moviesIds);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deletes a Franchise by id")
    @ApiResponses(value = {
            @ApiResponse( responseCode =  "204",
                    description = "Franchise deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class))}),
            @ApiResponse( responseCode = "404",
                    description = "Franchise with supplied id, does not exist! ",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))})
    @DeleteMapping("{id}")
    public ResponseEntity delete(@RequestBody FranchiseDeleteDTO entity, @PathVariable int id) {
        if (id != entity.getId()) // checks if the given id is same with the given franchise actual id
            return ResponseEntity.badRequest().build(); //if ids are different returns bad request response

        franchiseService.findById(entity.getId()).getMovies().forEach(f -> f.setFranchise(null)); //making null the movies of this franchise to be able to delete this franchise
        franchiseService.deleteById(id); //deletes the specific franchise
        return ResponseEntity.noContent().build();
    }
}
