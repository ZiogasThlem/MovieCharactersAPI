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
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @Column(length = 100)
    private String picture;
    @JsonIgnore
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;
}
