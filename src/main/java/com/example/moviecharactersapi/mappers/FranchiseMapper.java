package com.example.moviecharactersapi.mappers;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.Franchise;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.models.dto.franchise.FranchiseDTO;
import com.example.moviecharactersapi.models.dto.franchise.FranchiseGetCharacterDTO;
import com.example.moviecharactersapi.models.dto.franchise.FranchisegetMoviesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {

    @Mapping(target = "name", source = "name") //maybe not needed
    @Mapping(target = "description", source = "description") //maybe not needed
    @Mapping(target = "movies", qualifiedByName = "moviesToMoviesId")
    FranchiseDTO franchiseToFranchiseDTO(Franchise franchise);
    @Mapping(target = "movies", qualifiedByName = "moviesToMoviesId")
    Collection<FranchisegetMoviesDTO> franchiseGetMoviesDTO(Collection<Movie> movies);

//    @Mapping(target = "characters", qualifiedByName = "charactersToCharactersId")
//    Collection<FranchiseGetCharacterDTO> franchiseGetCharacterDTO(Collection<Character> movies);

    Collection<FranchiseDTO> franchiseToFranchiseDTO(Collection<Franchise> franchise);

    @Named(value = "moviesToMoviesId")
    default Set<Integer> map(Set<Movie> value){
        if(value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }

//    @Named(value = "charactersToCharactersId")
//    default Set<Integer> map(Set<Character> value) {
//        if (value == null)
//            return null;
//        return value.stream()
//                .map(s -> s.getId())
//                .collect(Collectors.toSet());
//    }
}
