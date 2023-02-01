package com.example.moviecharactersapi.controllers;

import com.example.moviecharactersapi.mappers.FranchiseMapper;
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

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
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
    public ResponseEntity add(@RequestBody Franchise entity) throws URISyntaxException {
        //add franchise
        franchiseMapper.franchiseToFranchiseDTO(
                franchiseService.add(entity));
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

    @GetMapping("{id}/movies")
    public ResponseEntity getMovies(@PathVariable int id){

        return ResponseEntity.ok(
                franchiseMapper.franchiseGetMoviesDTO(franchiseService.getMovies(id)));
    }

    @GetMapping("{id}/characters")
    public ResponseEntity getCharacters(@PathVariable int id){
        return ResponseEntity.ok(
                franchiseService.getCharacters(id));}

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
        if (id != entity.getId())
            return ResponseEntity.badRequest().build();

        franchiseService.findById(entity.getId()).getMovies().forEach(f -> f.setFranchise(null));
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
