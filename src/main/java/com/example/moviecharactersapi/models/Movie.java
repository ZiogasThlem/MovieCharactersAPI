package com.example.moviecharactersapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(length = 50, nullable = false)
    private String genre;
    @Column(nullable = false)
    private int year_of_release;
    @Column(length = 100, nullable = false)
    private String director;
    @Column(length = 100)
    private String picture;
    @Column(length = 100)
    private String trailer;
    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "movie_characters",
            joinColumns = {@JoinColumn(name = "movies_id")},
            inverseJoinColumns = {@JoinColumn(name = "characters_id")}
    )
    private Set<Character> characters;
}