package com.example.moviecharactersapi.services.service_classes;

import com.example.moviecharactersapi.entities.Movie;
import com.example.moviecharactersapi.repositories.MovieRepository;
import com.example.moviecharactersapi.services.service_interfaces.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl  implements MovieService {

    private final MovieRepository movieRepository;
    private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Integer integer) { return movieRepository.findById(integer).get(); }

    @Override
    public Collection<Movie> findAll() { return movieRepository.findAll(); }

    @Override
    public Movie add(Movie entity) { return movieRepository.save(entity); }

    @Override
    public Movie update(Movie entity) { return movieRepository.save(entity); }

    @Override
    public void deleteById(Integer integer) { movieRepository.deleteById(integer); }

    @Override
    public void delete(Movie entity) { movieRepository.delete(entity); }

    @Override
    public boolean exists(Integer integer) { return movieRepository.existsById(integer); }
}
