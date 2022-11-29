package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.MetierDto;
import com.projectincremental.entities.Metier;
import org.springframework.stereotype.Component;

@Component
public class MetierMapper {

    public MetierDto toDto(Metier metier) {
        MetierDto dto = new MetierDto();
        dto.setId(metier.getId());
        dto.setNom(metier.getNom());
        dto.setNiveau(metier.getNiveau());
        dto.setExperience(metier.getExperience());
        return dto;
    }
}
