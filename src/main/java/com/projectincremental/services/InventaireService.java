package com.projectincremental.services;

import com.projectincremental.dtos.InventaireDto;
import com.projectincremental.dtos.InventaireRessourceDto;
import com.projectincremental.entities.InventaireRessource;

import java.util.Optional;

public interface InventaireService {

    public InventaireDto getInvetaire();

    public Optional<InventaireRessource> updateInventaireRessource(long ressourceId, long quantite);

}
