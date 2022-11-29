package com.projectincremental.services.impl;

import com.projectincremental.dtos.CaracteristiqueDto;
import com.projectincremental.entities.Caracteristique;
import com.projectincremental.entities.Personnage;
import com.projectincremental.repositories.PersonnageRepository;
import com.projectincremental.services.PersonnageService;
import com.projectincremental.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonnaveServiceImpl implements PersonnageService {

    @Autowired
    private PersonnageRepository personnageRepository;
    @Autowired
    private ZoneService zoneService;

    @Override
    public Optional<List<Personnage>> findAll() {
        Long compteId = 1l;
        return personnageRepository.findAllByCompteId(compteId);
    }

    @Override
    public Personnage findById(Long personnageId) {
        return personnageRepository.findById(personnageId)
                .orElseThrow(() -> new EntityNotFoundException("Aucun personnage pour l'id " +personnageId));
    }

    @Override
    @Transactional
    public Optional<Personnage> updateZone(Long personnageId, Long zoneId) {
        Personnage personnage = findById(personnageId);
        // appel de la zone.
        personnage.setZone(zoneService.findById(zoneId).orElseThrow(() -> new EntityNotFoundException("Aucune zone pour l'id " +zoneId)));
        return Optional.ofNullable(updatePersonnage(personnage));
    }

    @Override
    @Transactional
    public Optional<Personnage> updateCaracteristique(Long personnageId, Caracteristique caracteristique) {

        Personnage personnage = findById(personnageId);
       personnage.setCaracteristique(caracteristique);
       return Optional.ofNullable(updatePersonnage(personnage));
    }
    public Personnage updatePersonnage(Personnage personnage) {
        return this.personnageRepository.save(personnage);
    }
}
