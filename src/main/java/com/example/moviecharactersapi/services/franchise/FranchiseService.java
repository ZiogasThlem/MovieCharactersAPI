package com.example.moviecharactersapi.services.franchise;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.models.Franchise;
import com.example.moviecharactersapi.models.dto.franchise.FranchiseDTO;
import com.example.moviecharactersapi.services.CrudService;

import java.util.Collection;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    Collection<Movie> getMovies(int franchiseId);
    Collection<Character> getCharacters(int franchiseId);
    void updateMovies(int franchiseId, int[] movies);
}
