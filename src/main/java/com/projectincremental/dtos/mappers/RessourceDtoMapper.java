package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.RessourceDto;
import com.projectincremental.entities.Ressource;
import org.springframework.stereotype.Component;

@Component
public class RessourceDtoMapper {

    public RessourceDto toDto(Ressource ressource) {
        RessourceDto dto = new RessourceDto();
        dto.setId(ressource.getId());
        dto.setNom(ressource.getNom());
        dto.setTauxDrop(ressource.getTauxDrop());
        return dto;
    }
}
