package com.dev.backendpense.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.backendpense.model.Questao;

@Repository
public interface RepositorioQuestoes extends CrudRepository<Questao,Integer>{
    
}
