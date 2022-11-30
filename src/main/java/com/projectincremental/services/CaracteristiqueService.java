package com.projectincremental.services;

import com.projectincremental.entities.Caracteristique;

import java.util.List;
import java.util.Optional;

public interface CaracteristiqueService {

    public Optional<Caracteristique> findById(Long caracteristiqueId);
    public Caracteristique getSommeCaracteristiqueById(List<Long> idCaracteristiques);
}
