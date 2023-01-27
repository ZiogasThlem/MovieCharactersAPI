package com.example.moviecharactersapi.entities;

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
    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movieSet;
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public Set<Movie> getMovieSet() {
//        return movieSet;
//    }
//    public void setMovieSet(Set<Movie> movieSet) {
//        this.movieSet = movieSet;
//    }
}
