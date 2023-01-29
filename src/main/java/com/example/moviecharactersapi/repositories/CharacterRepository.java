package com.example.moviecharactersapi.repositories;

import com.example.moviecharactersapi.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
