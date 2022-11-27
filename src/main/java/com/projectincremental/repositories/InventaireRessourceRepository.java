package com.projectincremental.repositories;

import com.projectincremental.entities.InventaireRessource;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


public interface InventaireRessourceRepository extends Repository<InventaireRessourceRepository, Long> {

    Optional<List<InventaireRessource>> findAllByCompteId(Long compteId);

    InventaireRessource create();
}
