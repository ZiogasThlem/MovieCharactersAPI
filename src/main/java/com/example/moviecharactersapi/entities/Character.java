package com.example.moviecharactersapi.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
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
    private String picture;
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String fullName) {
        this.full_name = fullName;
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
