package com.projectincremental.services;

import com.projectincremental.entities.Compte;

import java.util.Optional;

public interface CompteService {

    public Optional<Compte> findById(Long compteId);
}
