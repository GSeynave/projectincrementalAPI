package com.projectincremental.services;

import com.projectincremental.dtos.InventaireDto;
import com.projectincremental.dtos.InventaireRessourceDto;
import com.projectincremental.entities.InventaireConsommable;
import com.projectincremental.entities.InventaireEquipement;
import com.projectincremental.entities.InventaireRessource;

import java.util.Optional;

public interface InventaireService {

    public InventaireDto getInvetaire();

    public Optional<InventaireRessource> updateInventaireRessource(long ressourceId, long quantite);

    Optional<InventaireEquipement> updateInventaireEquipement(long equipementId, long personnageId, long quantite);

    Optional<InventaireConsommable> updateInventaireConsommable(long consommableId, long quantite);
}
