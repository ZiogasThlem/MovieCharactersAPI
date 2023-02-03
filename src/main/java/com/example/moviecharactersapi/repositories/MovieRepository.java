package com.example.moviecharactersapi.repositories;

import com.example.moviecharactersapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
