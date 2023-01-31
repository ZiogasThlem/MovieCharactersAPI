package com.example.moviecharactersapi.services.franchise;

import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.models.Franchise;
import com.example.moviecharactersapi.services.CrudService;

import java.util.Collection;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    Collection<Movie> getMovies(int moviesId);
}
