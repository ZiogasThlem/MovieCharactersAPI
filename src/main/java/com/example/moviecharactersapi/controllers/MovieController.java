package com.example.moviecharactersapi.controllers;

import com.example.moviecharactersapi.mappers.MovieMapper;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.models.dto.movie.MovieDTO;
import com.example.moviecharactersapi.models.dto.movie.MovieDeleteDTO;
import com.example.moviecharactersapi.services.movie.MovieService;
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
@RequestMapping(path = "api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    private  final MovieMapper movieMapper;
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @Operation(summary = "Gets all the Movies")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {@Content( mediaType = "application/json",
                            array = @ArraySchema( schema = @Schema(implementation = MovieDTO.class)))})
    })
    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
            movieMapper.movieToMovieDTO(
                    movieService.findAll())); }

    @Operation(summary = "Finds the Movie with the specific id")
    @ApiResponses(value = {
            @ApiResponse( responseCode =  "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class))}),
            @ApiResponse( responseCode = "404",
                    description = "Movie does not exist with supplied id",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))})
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(
                movieMapper.movieToMovieDTO(
                        movieService.findById(id))); }


    @Operation(summary = "Adds a new Movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Created",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity add(@RequestBody MovieDTO entity) throws URISyntaxException {
        //add movie
        movieMapper.movieToMovieDTO(
                movieService.add(movieService.findById(entity.getId()))); //calls the movie service to add the character by id
        //creating uri with new movies id
        URI uri = new URI("api/v1/movies/" + entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Updates a Movie with a specific id")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "204",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))}),
            @ApiResponse( responseCode = "404",
                    description = "Movie not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))})
    })
    @PostMapping("{id}")
    public ResponseEntity update(@RequestBody MovieDTO entity,@PathVariable int id){
        if(id != entity.getId()) //checks if the given id is same with the given movie actual id
            return ResponseEntity.badRequest().build(); //if ids are different returns bad request response
        movieMapper.movieToMovieDTO(
                movieService.update(movieService.findById(entity.getId()))); //updates the movie
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Gets all the Characters from a Movie with a specific id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {@Content( mediaType = "application/json",
                            array = @ArraySchema( schema = @Schema(implementation = MovieDTO.class)))})
    })
    @GetMapping("{id}/characters")
    public ResponseEntity getCharacters(@PathVariable int id){
        return ResponseEntity.ok(movieService.getCharacters(id));
    }


    @Operation(summary = "Updates characters in a movie")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "204",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))}),
            @ApiResponse( responseCode = "404",
                    description = "Character not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))})
    })
    @PutMapping("{id}/characters")
    public ResponseEntity updateCharacters(@PathVariable int id, @RequestBody int[] charactersIds){
        movieService.updateCharacters(id,charactersIds);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deletes the Movie with the specific id")
    @ApiResponses(value = {
            @ApiResponse( responseCode =  "204",
                    description = "Movie deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class))}),
            @ApiResponse( responseCode = "404",
                    description = "Movie with supplied id, does not exist!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))})
    @DeleteMapping("{id}")
    public ResponseEntity delete(@RequestBody MovieDeleteDTO entity, @PathVariable int id) {
        if (id != entity.getId()) // checks if the given id is same with the given movies actual id
            return ResponseEntity.badRequest().build();  //if ids are different returns bad request response
        movieService.deleteById(id); //deletes the specific movie
        return ResponseEntity.noContent().build();
    }
}
