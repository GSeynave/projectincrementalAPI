package com.projectincremental.dtos;

import java.util.List;

public class InventaireDto {

    List<InventaireRessourceDto> inventaireRessources;
    List<InventaireEquipementDto> inventaireEquipements;
    List<InventaireConsommableDto> inventaireConsommables;

    public List<InventaireRessourceDto> getInventaireRessources() {
        return inventaireRessources;
    }

    public void setInventaireRessources(List<InventaireRessourceDto> inventaireRessources) {
        this.inventaireRessources = inventaireRessources;
    }

    public List<InventaireEquipementDto> getInventaireEquipements() {
        return inventaireEquipements;
    }

    public void setInventaireEquipements(List<InventaireEquipementDto> inventaireEquipements) {
        this.inventaireEquipements = inventaireEquipements;
    }

    public List<InventaireConsommableDto> getInventaireConsommables() {
        return inventaireConsommables;
    }

    public void setInventaireConsommables(List<InventaireConsommableDto> inventaireConsommables) {
        this.inventaireConsommables = inventaireConsommables;
    }
}
