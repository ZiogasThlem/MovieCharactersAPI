package com.example.moviecharactersapi.services.service_classes;

import com.example.moviecharactersapi.repositories.FranchiseRepository;
import com.example.moviecharactersapi.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FranchiseServiceImpl{//} implements FranchiseService{

    private final FranchiseRepository franchiseRepository;
    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);


    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }
}
