package com.projectincremental.repositories;

import com.projectincremental.entities.InventaireRessource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface InventaireRessourceRepository extends JpaRepository<InventaireRessource, Long> {

    Optional<List<InventaireRessource>> findAllByUserId(Long userId);


    Optional<InventaireRessource> findByUserIdAndRessourceId(Long userId, long ressourceId);
}
