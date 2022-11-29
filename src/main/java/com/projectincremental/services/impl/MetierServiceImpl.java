package com.projectincremental.services.impl;

import com.projectincremental.dtos.ProgressMetier;
import com.projectincremental.entities.Metier;
import com.projectincremental.repositories.MetierRepository;
import com.projectincremental.services.MetierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MetierServiceImpl implements MetierService {

    @Autowired
    private MetierRepository metierRepository;

    @Override
    public List<Metier> getMetiers() {
        long compteId = 1l;
        return metierRepository.findAllByCompteId(compteId)
                .orElseThrow(() -> new EntityNotFoundException("Aucun metier pour le compte id " +compteId));
    }

    @Override
    @Transactional
    public Metier updateMetier(long metierId, ProgressMetier progressMetier) {
        Metier metier = findById(metierId);
        metier.setNiveau(progressMetier.getNiveau());
        metier.setExperience(progressMetier.getExperience());
        return save(metier);
    }


    private Metier findById(long metierId) {
        return metierRepository.findById(metierId)
                .orElseThrow(() -> new EntityNotFoundException("Aucun metier pour l'id " +metierId));
    }

    private Metier save(Metier metier) {
        return metierRepository.save(metier);
    }
}
