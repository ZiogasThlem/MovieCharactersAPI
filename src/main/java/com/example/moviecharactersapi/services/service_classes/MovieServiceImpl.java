package com.example.moviecharactersapi.services.service_classes;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.repositories.CharacterRepository;
import com.example.moviecharactersapi.repositories.MovieRepository;
import com.example.moviecharactersapi.services.service_interfaces.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class MovieServiceImpl  implements MovieService {

    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;
    private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    public MovieServiceImpl(MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
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


    @Override
    public Collection<Character> getCharacters(int characterId) {
        return movieRepository.findById(characterId).get().getCharacters();
    }

    @Override
    public void updateCharacters(int movieId, int[] characters) {
        Movie movie = movieRepository.findById(movieId).get();
        Set<Character> characterList = new HashSet<>();
        for (int id : characters) {
            characterList.add(characterRepository.findById(id).get());
      }
        movie.setCharacters(characterList);
        movieRepository.save(movie);
    }
}
