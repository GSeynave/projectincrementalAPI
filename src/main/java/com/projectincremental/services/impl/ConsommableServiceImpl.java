package com.projectincremental.services.impl;

import com.projectincremental.entities.Consommable;
import com.projectincremental.repositories.ConsommableRepository;
import com.projectincremental.services.ConsommableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ConsommableServiceImpl implements ConsommableService {

    @Autowired
    private ConsommableRepository consommableRepository;

    @Override
    public Consommable findById(long consommableId) {
        return consommableRepository.findById(consommableId)
                .orElseThrow(() -> new EntityNotFoundException("Aucun consommable pour l'id " +consommableId));
    }
}
