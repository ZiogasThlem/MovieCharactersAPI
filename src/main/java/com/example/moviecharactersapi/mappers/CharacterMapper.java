package com.example.moviecharactersapi.mappers;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.models.dto.character.CharacterDTO;
import com.example.moviecharactersapi.models.dto.movie.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    
    @Mapping(target = "movies", qualifiedByName = "moviesToMoviesId")
    CharacterDTO characterToCharacterDTO(Character character);

    Collection<CharacterDTO> characterToCharacterDTO(Collection<Character> character);

    @Mapping(target = "movies", ignore = true)
    Character characterDtoToCharacter(CharacterDTO characterDTO);

    @Named(value = "moviesToMoviesId")
    default Set<Integer> map(Set<Movie> value){
        if(value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
