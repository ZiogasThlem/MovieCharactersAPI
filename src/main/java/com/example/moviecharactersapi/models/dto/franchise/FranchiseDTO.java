package com.example.moviecharactersapi.models.dto.franchise;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

/* This DTO created for user to work with a franchise */
@Getter
@Setter
public class FranchiseDTO {

    private int id;
    private String name;
    private String description;
    private Set<Integer> movies;
}
