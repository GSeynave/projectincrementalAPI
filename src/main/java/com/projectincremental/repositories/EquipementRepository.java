package com.projectincremental.repositories;

import com.projectincremental.entities.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipementRepository  extends JpaRepository<Equipement, Long> {

    Optional<Equipement> findById(long equipementId);
}
