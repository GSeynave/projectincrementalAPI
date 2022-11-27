package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.InventaireConsommableDto;
import com.projectincremental.entities.InventaireConsommable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventaireConsommableMapper {

    @Autowired
    private ConsommableMapper consommableMapper;

    public InventaireConsommableDto toDto(InventaireConsommable inventaireConsommable) {
        InventaireConsommableDto dto = new InventaireConsommableDto();
        dto.setId(inventaireConsommable.getId());
        dto.setQuantite(inventaireConsommable.getQuantite());
        dto.setConsommable(consommableMapper.toDto(inventaireConsommable.getConsommable()));
        return dto;
    }
}
