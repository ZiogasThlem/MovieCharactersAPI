package com.example.moviecharactersapi.services.franchise;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.Franchise;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.repositories.FranchiseRepository;
import com.example.moviecharactersapi.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;
    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);


    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Franchise findById(Integer integer) { return franchiseRepository.findById(integer).get(); }

    @Override
    public Collection<Franchise> findAll() { return franchiseRepository.findAll(); }

    @Override
    public Franchise add(Franchise entity) { return franchiseRepository.save(entity); }

    @Override
    public Franchise update(Franchise entity) { return franchiseRepository.save(entity); }

    @Override
    public void deleteById(Integer integer) { franchiseRepository.deleteById(integer); }

    @Override
    public void delete(Franchise entity) { franchiseRepository.delete(entity); }

    @Override
    public boolean exists(Integer integer) { return franchiseRepository.existsById(integer); }

    @Override
    public Collection<Movie> getMovies(int franchiseId) {
        return franchiseRepository.findById(franchiseId).get().getMovies();
    }

    @Override
    public Collection<Character> getCharacters(int franchiseId) {
        Collection<Movie> movies = franchiseRepository.findById(franchiseId).get().getMovies(); //getting the movies of a franchise
        Collection<Character> charactersOfMovies = new HashSet<>(); //creating a collection which will hold all the characters of every movie in a franchise
        movies.forEach(s->s.getCharacters().addAll(charactersOfMovies)); //for each movie in the franchise adding the characters in the charactersOfMovies collection
        return charactersOfMovies; //returns alla the characters
    }

    @Override
    public void updateMovies(int franchiseId, int[] movies) {
        Franchise franchise = franchiseRepository.findById(franchiseId).get(); //getting the franchise from id
        Set<Movie> moviesList = new HashSet<>(); //creating a set to hold the movies
        for(int id : movies){ //for every movie id
            movieRepository.findById(id).get().setFranchise(franchise);
            moviesList.add(movieRepository.findById(id).get()); //add this movie to the movieList
        }
        franchise.setMovies(moviesList); //setting this set of movies to the franchise
        franchiseRepository.save(franchise); //saving the updated franchise
    }
}
