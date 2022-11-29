package com.projectincremental.services;

import com.projectincremental.dtos.CaracteristiqueDto;
import com.projectincremental.entities.Caracteristique;
import com.projectincremental.entities.Personnage;

import java.util.List;
import java.util.Optional;

public interface PersonnageService {

    Optional<List<Personnage>> findAll();
    Optional<Personnage> findById(Long personnageId);
    Optional<Personnage> updateZone(Long personnageId, Long zoneId);

    Optional<Personnage> updateCaracteristique(Long personnageId, Caracteristique caracteristique);
}
