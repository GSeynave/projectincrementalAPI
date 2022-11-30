package com.projectincremental.services;

import com.projectincremental.entities.Equipement;

import java.util.List;
import java.util.Optional;

public interface EquipementService {

    Equipement findById(long equipementId);
}
