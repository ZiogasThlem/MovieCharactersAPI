package com.example.moviecharactersapi.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length=30, nullable = false)
    private String fullName;
    @Column(length=50)
    private String alias;
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    private String picture;

    @ManyToMany(mappedBy = "movies")
    private Set<Movie> movies;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
