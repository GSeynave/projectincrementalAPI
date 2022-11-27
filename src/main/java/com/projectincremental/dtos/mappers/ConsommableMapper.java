package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.ConsommableDto;
import com.projectincremental.entities.Consommable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConsommableMapper {

    @Autowired
    private RessourceCraftMapper ressourceCraftMapper;
    @Autowired
    private CaracteristiqueMapper caracteristiqueMapper;
    public ConsommableDto toDto(Consommable consommable) {

        ConsommableDto dto = new ConsommableDto();
        dto.setId(consommable.getId());
        dto.setNiveau(consommable.getNiveau());
        dto.setNom(consommable.getNom());
        dto.setCaracteristique(caracteristiqueMapper.toDto(consommable.getCaracteristique()));
        dto.setRessourceCrafts(consommable.getRessourceCrafts().stream().map(ressourceCraftMapper::toDto).collect(Collectors.toList()));
        return dto;
    }
}
