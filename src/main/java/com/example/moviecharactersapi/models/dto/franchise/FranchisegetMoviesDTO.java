package com.example.moviecharactersapi.models.dto.franchise;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class FranchisegetMoviesDTO {
    private int id;
    private Set<Integer> movies;
}
