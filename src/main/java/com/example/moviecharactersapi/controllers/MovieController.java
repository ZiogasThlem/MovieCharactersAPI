package com.example.moviecharactersapi.controllers;

import com.example.moviecharactersapi.models.Franchise;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.models.dto.movie.MovieDTO;
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
    public ResponseEntity findById(@PathVariable int id){ return ResponseEntity.ok(movieService.findById(id)); }


    @Operation(summary = "Adds a new Movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Created",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity add(@RequestBody Movie entity) throws URISyntaxException {
        //add movie
        movieService.add(entity);
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
    public ResponseEntity update(@RequestBody Movie entity,@PathVariable int id){
        if(id != entity.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(entity);
        return ResponseEntity.noContent().build();
    }

//    @Operation(summary = "Gets all the Characters from a Movie with a specific id")
//    @ApiResponses(value={
//            @ApiResponse(responseCode = "200",
//                    description = "Success",
//                    content = {@Content( mediaType = "application/json",
//                            array = @ArraySchema( schema = @Schema(implementation = MovieDTO.class)))})
//    })
    @GetMapping("{id}/characters")
    public ResponseEntity getCharacters(@PathVariable int id){
        return ResponseEntity.ok(movieService.getCharacters(id));
    }


//    @Operation(summary = "Updates the requested by id Characters from a Movie with a specific id")
//    @ApiResponses(value = {
//            @ApiResponse( responseCode = "204",
//                    description = "Success",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = MovieDTO.class))}),
//            @ApiResponse(responseCode = "400",
//                    description = "Bad Request",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = ProblemDetail.class))}),
//            @ApiResponse( responseCode = "404",
//                    description = "Character not found",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = ProblemDetail.class))})
//    })
    @PutMapping("{id}/characters")
    public ResponseEntity updateCharacters(@PathVariable int id, @RequestBody int[] charactersIds){
        movieService.updateCharacters(id,charactersIds);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{id}")
    public ResponseEntity delete(@RequestBody Movie entity, @PathVariable int id) {
        if (id != entity.getId())
            return ResponseEntity.badRequest().build();

//        entity.getCharacters().forEach(m -> m.setMovies());
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
