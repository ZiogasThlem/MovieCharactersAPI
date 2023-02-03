package com.example.moviecharactersapi.mappers;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.Franchise;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.models.dto.character.CharacterDTO;
import com.example.moviecharactersapi.models.dto.franchise.FranchiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {

    @Mapping(target = "movies", qualifiedByName = "moviesToMoviesId")
    FranchiseDTO franchiseToFranchiseDTO(Franchise franchise);

    Collection<FranchiseDTO> franchiseToFranchiseDTO(Collection<Franchise> franchise);

    @Mapping(target = "movies", ignore = true)
    Franchise franchiseDtoToFranchise(FranchiseDTO franchiseDTO);

    @Named(value = "moviesToMoviesId")
    default Set<Integer> map(Set<Movie> value){
        if(value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
