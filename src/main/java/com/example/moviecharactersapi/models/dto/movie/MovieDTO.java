package com.example.moviecharactersapi.models.dto.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {
    private int id;
    private String title;
    private String genre;
    private String year_of_release;

}
