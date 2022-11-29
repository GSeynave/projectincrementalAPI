package com.projectincremental.services.impl;

import com.projectincremental.entities.Compte;
import com.projectincremental.repositories.CompteRepository;
import com.projectincremental.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Compte findById(Long compteId) {
        return compteRepository.findById(compteId)
                .orElseThrow(() -> new EntityNotFoundException("Aucun comte pour l'id " +compteId));
    }
}
