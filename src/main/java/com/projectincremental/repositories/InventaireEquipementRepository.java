package com.projectincremental.repositories;

import com.projectincremental.entities.InventaireEquipement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventaireEquipementRepository extends JpaRepository<InventaireEquipement, Long> {

    Optional<List<InventaireEquipement>> findAllByCompteId(Long compteId);

    InventaireEquipement save(InventaireEquipement equipement);

    Optional<InventaireEquipement> findByCompteIdAndPersonnageIdAndEquipementId(Long id, Long id1, long equipementId);
}
