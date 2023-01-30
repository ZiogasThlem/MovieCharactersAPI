package com.example.moviecharactersapi.models.dto.character;

import com.example.moviecharactersapi.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharacterDTO {
    private int id;
    private String full_name;
    private String alias;
    private String gender;
    private String picture;
    private Set<Movie> movies;
}
