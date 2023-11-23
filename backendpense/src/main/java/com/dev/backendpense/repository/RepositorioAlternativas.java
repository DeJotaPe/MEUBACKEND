package com.dev.backendpense.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.backendpense.model.Alternativa;

@Repository
public interface RepositorioAlternativas extends CrudRepository<Alternativa, Integer>{
    
}
