package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.InventaireRessourceDto;
import com.projectincremental.entities.InventaireRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventaireRessourceMapper {

    @Autowired
    private RessourceDtoMapper mapper;

    public InventaireRessourceDto toDto(InventaireRessource inventaireRessource) {
        InventaireRessourceDto dto = new InventaireRessourceDto();
        dto.setRessource(mapper.toDto(inventaireRessource.getRessource()));
        dto.setQuantite(inventaireRessource.getQuantite());
        return dto;
    }
}
