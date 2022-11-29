package com.projectincremental.services;

import com.projectincremental.entities.Equipement;

import java.util.Optional;

public interface EquipementService {

    Equipement findById(long equipementId);
}
