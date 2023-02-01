package com.example.moviecharactersapi.models.dto.character;

import com.example.moviecharactersapi.models.Movie;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

@Getter
@Setter
public class CharacterDeleteDTO {
    private int id;
}
