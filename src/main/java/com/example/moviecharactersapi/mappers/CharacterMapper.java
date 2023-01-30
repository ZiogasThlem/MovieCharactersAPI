package com.example.moviecharactersapi.mappers;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.dto.character.CharacterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

//    @Mapping(target = "movie", source = "movie.id")
//    CharacterDTO characterToCharacterDTO(Character character);
//
//    Collection<CharacterDTO> characterToCharacterDTO(Collection<Character> character);
}
