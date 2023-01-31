package com.example.moviecharactersapi.services.franchise;

import com.example.moviecharactersapi.models.Franchise;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.repositories.FranchiseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);


    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
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
    public Collection<Movie> getMovies(int moviesId) {
        return franchiseRepository.findById(moviesId).get().getMovies();
    }
}
