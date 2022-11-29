package com.projectincremental.services;

import com.projectincremental.entities.Compte;

import java.util.Optional;

public interface CompteService {

    public Compte findById(Long compteId);
}
