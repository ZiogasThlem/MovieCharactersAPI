package com.example.moviecharactersapi.runner;

import com.example.moviecharactersapi.repositories.CharacterRepository;
import com.example.moviecharactersapi.repositories.FranchiseRepository;
import com.example.moviecharactersapi.repositories.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PgApplicationRunner implements ApplicationRunner {

    private final MovieRepository movieRepository;
    private final CharacterRepository actorRepository;
    private final FranchiseRepository franchiseRepository;

    public PgApplicationRunner(MovieRepository movieRepository,
                               CharacterRepository actorRepository,
                               FranchiseRepository franchiseRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
