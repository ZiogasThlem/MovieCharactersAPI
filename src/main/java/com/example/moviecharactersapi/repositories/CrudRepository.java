package com.example.moviecharactersapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository<T, ID> extends JpaRepository<T, ID> {
}
