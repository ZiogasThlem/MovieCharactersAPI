package com.example.moviecharactersapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 1000)
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movieSet;
}
