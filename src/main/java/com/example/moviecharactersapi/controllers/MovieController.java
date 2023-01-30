package com.example.moviecharactersapi.controllers;

import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.models.dto.character.CharacterDTO;
import com.example.moviecharactersapi.models.dto.movie.MovieDTO;
import com.example.moviecharactersapi.services.movie.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;}

    @Operation(summary = "Gets all the Movies")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {@Content( mediaType = "application/json",
                            array = @ArraySchema( schema = @Schema(implementation = MovieDTO.class)))})
    })
    @GetMapping
    public ResponseEntity findAll(){ return ResponseEntity.ok(movieService.findAll()); }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){ return ResponseEntity.ok(movieService.findById(id)); }

    @PostMapping
    public ResponseEntity add(@RequestBody Movie entity) throws URISyntaxException {
        //add movie
        movieService.add(entity);
        //creating uri with new movies id
        URI uri = new URI("api/v1/movies/" + entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("{id}")
    public ResponseEntity update(@RequestBody Movie entity,@PathVariable int id){
        if(id != entity.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(entity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/characters")
    public ResponseEntity getCharacters(@PathVariable int id){
        return ResponseEntity.ok(movieService.getCharacters(id));
    }

    @PutMapping("{id}/characters")
    public ResponseEntity updateCharacters(@PathVariable int id, @RequestBody int[] charactersIds){
        movieService.updateCharacters(id,charactersIds);
        return ResponseEntity.noContent().build();
    }
}
