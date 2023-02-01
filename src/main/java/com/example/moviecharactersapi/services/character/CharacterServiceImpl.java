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
    public void deleteById(Integer integer) { characterRepository.deleteById(integer); }

    @Override
    public void delete(Character entity) {
        for (Movie movie: entity.getMovies()){
            entity.removeMovie(movie);
        }
        characterRepository.delete(entity);
    }

    @Override
    public boolean exists(Integer integer) {
        return characterRepository.existsById(integer);
    }
}
