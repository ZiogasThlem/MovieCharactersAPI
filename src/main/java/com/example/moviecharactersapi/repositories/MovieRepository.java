package com.example.moviecharactersapi.repositories;

import com.example.moviecharactersapi.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
