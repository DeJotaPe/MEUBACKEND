package com.dev.backendpense.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.backendpense.model.User;

@Repository
public interface RepositorioUsers extends CrudRepository<User,Integer>{
    
}