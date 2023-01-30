package com.example.moviecharactersapi.exceptions;

import static java.lang.String.format;

public class FranchiseNotFoundException extends EntityNotFoundException{

    public FranchiseNotFoundException(int id) {
        super(format("Franchise with id %d does not exist", id));
    }
}
