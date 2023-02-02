package com.example.moviecharactersapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
public class  Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length=50, nullable = false)
    private String full_name;
    @Column(length=50)
    private String alias;
    @Column(length=20)
    private String gender;
    @Column(length = 100)
    private String picture;
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;

    public void removeMovie(Movie movie) { //this function made to remove a movie from a character
        this.movies.remove(movie);
        movie.getCharacters().remove(this);
    }
}
