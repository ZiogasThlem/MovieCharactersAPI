package com.example.moviecharactersapi.models.dto.movie;

import com.example.moviecharactersapi.models.dto.character.CharacterListDTO;
import com.example.moviecharactersapi.models.dto.franchise.FranchiseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MovieDTO {
    private int id;
    private String title;
    private String genre;
    private String year_of_release;
    private FranchiseDTO franchise; //
    private Set<CharacterListDTO> characters; //

}
