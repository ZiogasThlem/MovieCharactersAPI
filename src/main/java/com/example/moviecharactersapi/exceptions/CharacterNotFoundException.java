package com.example.moviecharactersapi.exceptions;

import static java.lang.String.format;

public class CharacterNotFoundException extends EntityNotFoundException{
    public CharacterNotFoundException(int id) {
        super(format("Character with id %d does not exist",id));
    }
}
