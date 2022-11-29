package com.projectincremental.services.impl;

import com.projectincremental.entities.Ressource;
import com.projectincremental.repositories.RessourceRepository;
import com.projectincremental.services.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RessourceServiceImpl implements RessourceService {

@Autowired
private RessourceRepository ressourceRepository;

    public Optional<Ressource> findById(Long ressourceId) {
        return ressourceRepository.findById(ressourceId);
    }
}
