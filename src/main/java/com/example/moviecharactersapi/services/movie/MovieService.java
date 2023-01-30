package com.example.moviecharactersapi.services.movie;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.services.CrudService;

import java.util.Collection;

public interface MovieService extends CrudService<Movie, Integer> {
    Collection<Character> getCharacters(int characterId);
    void updateCharacters(int movieId, int[] characters);
}
