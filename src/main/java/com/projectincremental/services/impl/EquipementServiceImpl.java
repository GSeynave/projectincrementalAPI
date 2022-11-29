package com.projectincremental.services.impl;

import com.projectincremental.entities.Equipement;
import com.projectincremental.repositories.EquipementRepository;
import com.projectincremental.services.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class EquipementServiceImpl implements EquipementService {

    @Autowired
    private EquipementRepository equipementRepository;

    @Override
    public Equipement findById(long equipementId) {
        return equipementRepository.findById(equipementId)
                .orElseThrow(() -> new EntityNotFoundException("Aucun equipement pour l'id " +equipementId));
    }
}
