package com.projectincremental.repositories;

import com.projectincremental.entities.InventaireRessource;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface InventaireRessourceRepository extends Repository<InventaireRessource, Long> {

    Optional<List<InventaireRessource>> findAllByCompteId(Long compteId);
}
