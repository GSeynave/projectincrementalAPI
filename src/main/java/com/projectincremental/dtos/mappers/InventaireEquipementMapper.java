package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.InventaireEquipementDto;
import com.projectincremental.entities.InventaireEquipement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventaireEquipementMapper {
    @Autowired
    private EquipementMapper equipementMapper;
    public InventaireEquipementDto toDto(InventaireEquipement inventaireEquipement) {
        InventaireEquipementDto dto = new InventaireEquipementDto();
        dto.setEquipement(equipementMapper.toDto(inventaireEquipement.getEquipement()));
        dto.setQuantite(inventaireEquipement.getQuantite());
        dto.setPersonnage(inventaireEquipement.getPersonnage().getId());
        return dto;
    }
}