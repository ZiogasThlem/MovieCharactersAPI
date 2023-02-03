package com.example.moviecharactersapi.mappers;

import com.example.moviecharactersapi.models.Character;
import com.example.moviecharactersapi.models.Franchise;
import com.example.moviecharactersapi.models.Movie;
import com.example.moviecharactersapi.models.dto.movie.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "franchise", source = "franchise" , qualifiedByName = "franchiseToFranchiseId")
    @Mapping(target = "characters", source ="characters", qualifiedByName = "charactersToCharactersId")
    MovieDTO movieToMovieDTO(Movie movie);

    Collection<MovieDTO> movieToMovieDTO(Collection<Movie> movie);

    @Mapping(target = "franchise", ignore = true)
    @Mapping(target = "characters", ignore = true)
    Movie movieDtoToMovie(MovieDTO movieDTO);

    @Named(value = "charactersToCharactersId")
    default Set<Integer> map(Set<Character> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
    @Named(value = "franchiseToFranchiseId")
    default Integer map(Franchise value) {
        if (value == null)
            return 0;
        return value.getId();
    }
}
