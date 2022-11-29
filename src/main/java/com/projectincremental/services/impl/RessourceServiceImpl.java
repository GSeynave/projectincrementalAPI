package com.projectincremental.services.impl;

import com.projectincremental.entities.Ressource;
import com.projectincremental.repositories.RessourceRepository;
import com.projectincremental.services.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class RessourceServiceImpl implements RessourceService {

@Autowired
private RessourceRepository ressourceRepository;

    public Ressource findById(Long ressourceId) {
        return ressourceRepository.findById(ressourceId)
                .orElseThrow(() -> new EntityNotFoundException("Aucune ressource pour l'id " +ressourceId));
    }
}
