package com.projectincremental.services.impl;

import com.projectincremental.entities.Compte;
import com.projectincremental.repositories.CompteRepository;
import com.projectincremental.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Optional<Compte> findById(Long compteId) {
        return compteRepository.findById(compteId);
    }
}
