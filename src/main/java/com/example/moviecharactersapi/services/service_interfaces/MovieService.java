package com.example.moviecharactersapi.services.service_interfaces;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.Movie;

import java.util.Collection;

public interface MovieService extends CrudService<Movie, Integer>{
    Collection<Character> getCharacters(int characterId);
    void updateCharacters(int movieId, int[] characters);
}
