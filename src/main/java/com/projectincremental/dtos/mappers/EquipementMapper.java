package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.EquipementDto;
import com.projectincremental.entities.Equipement;
import com.projectincremental.entities.InventaireRessource;
import com.projectincremental.entities.RessourceCraft;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipementMapper {

    @Autowired
    private CaracteristiqueMapper caracteristiqueMapper;
    @Autowired
    private RessourceCraftMapper ressourceCraftMapper;
    @Autowired
    private InventaireRessourceMapper inventaireRessourceMapper;
    public EquipementDto toDto(Equipement equipement) {
        EquipementDto dto = new EquipementDto();
        dto.setId(equipement.getId());
        dto.setNiveau(equipement.getNiveau());
        dto.setNom(equipement.getNom());
        dto.setCaracteristique(caracteristiqueMapper.toDto(equipement.getCaracteristique()));
        dto.setRessourcesCraft(equipement.getRessourceCrafts()
                .stream()
                .map(ressourceCraftMapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
