package com.example.moviecharactersapi.services.character;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.repositories.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).get();
    }

    @Override
    public Collection<Character> findAll() { return characterRepository.findAll(); }

    @Override
    public Character add(Character entity) { return characterRepository.save(entity); }

    @Override
    public Character update(Character entity) { return characterRepository.save(entity); }

    @Override
    public void deleteById(Integer integer) {
        //removing the movies of the specific character to be able to delete this character
        for (Movie movie: characterRepository.getReferenceById(integer).getMovies()){ //for every movie in movies Set of character
            characterRepository.getReferenceById(integer).removeMovie(movie); //remove this movie
        }
        characterRepository.deleteById(integer); } //deletes the character
}
