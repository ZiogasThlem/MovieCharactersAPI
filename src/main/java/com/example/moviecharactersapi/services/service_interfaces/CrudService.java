package com.example.moviecharactersapi.services.service_interfaces;

import java.util.Collection;

public interface CrudService <T, ID> {
    T findById(ID id);
    Collection<T> findAll();
    T add(T entity);
    T update(T entity);
    void deleteById(ID id);
    void delete(T entity);
}