package com.example.moviecharactersapi.models.dto.movie;

import com.example.moviecharactersapi.models.Franchise;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
@Getter
@Setter
public class MovieDTO {
    private int id;
    private String title;
    private String genre;
    private String year_of_release;
    private int franchise;
    private Collection<Integer> characters;

}
