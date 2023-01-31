package com.example.moviecharactersapi.models.dto.franchise;

import com.example.moviecharactersapi.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class FranchiseDTO {

    private int id;
    private String name;
    private String description;
    private Set<Integer> movies;
}
