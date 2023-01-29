package com.example.moviecharactersapi.exceptions;

import static java.lang.String.format;

public class MovieNotFoundException extends EntityNotFoundException {

    public MovieNotFoundException(int id) {
        super(format("Movie with id %d does not exist", id));
    }

}
