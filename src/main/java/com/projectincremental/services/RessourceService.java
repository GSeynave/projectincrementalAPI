package com.projectincremental.services;

import com.projectincremental.entities.Ressource;

import java.util.Optional;

public interface RessourceService {

    public Ressource findById(Long ressourceId);
}
