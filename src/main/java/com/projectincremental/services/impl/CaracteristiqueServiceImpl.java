package com.projectincremental.services.impl;

import com.projectincremental.entities.Caracteristique;
import com.projectincremental.repositories.CaracteristiqueRepository;
import com.projectincremental.services.CaracteristiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaracteristiqueServiceImpl implements CaracteristiqueService {

    @Autowired
    private CaracteristiqueRepository caracteristiqueRepository;

    @Override
    public Optional<Caracteristique> findById(Long caracteristiqueId) {
        return caracteristiqueRepository.findById(caracteristiqueId);
    }
}
