package com.dev.backendpense.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.backendpense.model.Prova;

@Repository
public interface RepositorioProvas extends CrudRepository<Prova,Integer>{
    
}



