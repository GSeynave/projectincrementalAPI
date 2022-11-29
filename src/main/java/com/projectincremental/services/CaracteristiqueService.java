package com.projectincremental.services;

import com.projectincremental.entities.Caracteristique;

import java.util.Optional;

public interface CaracteristiqueService {

    public Optional<Caracteristique> findById(Long caracteristiqueId);
}
