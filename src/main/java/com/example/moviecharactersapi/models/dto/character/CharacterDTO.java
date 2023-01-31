package com.example.moviecharactersapi.models.dto.character;

import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.models.dto.movie.MovieDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharacterDTO {
    private int id;
    private String name;
    private Set<Integer> movies;
}
