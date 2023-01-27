package com.example.moviecharactersapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @ManyToMany
    private Set<Character> characters;
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    public String getGenre() {
//        return genre;
//    }
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//    public int getYear_of_release() {
//        return year_of_release;
//    }
//    public void setYear_of_release(int yearOfRelease) {
//        this.year_of_release = yearOfRelease;
//    }
//    public String getDirector() {
//        return director;
//    }
//    public void setDirector(String director) {
//        this.director = director;
//    }
//    public String getPicture() {
//        return picture;
//    }
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }
//    public String getTrailer() {
//        return trailer;
//    }
//    public void setTrailer(String trailer) {
//        this.trailer = trailer;
//    }
//    public Franchise getFranchise() {
//        return franchise;
//    }
//    public void setFranchise(Franchise franchise) {
//        this.franchise = franchise;
//    }
//    public Set<Character> getCharacters() {
//        return characters;
//    }
//    public void setCharacters(Set<Character> characters) {
//        this.characters = characters;
//    }
}