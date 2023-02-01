package com.example.moviecharactersapi.models.dto.character;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharacterDTO {
    private int id;
    private String name;
    private String alias;
    private String gender;
    private String picture;
    private Set<Integer> movies;
}
