package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.RessourceCraftDto;
import com.projectincremental.entities.RessourceCraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RessourceCraftMapper {

    @Autowired
    private RessourceDtoMapper ressourceDtoMapper;

    public RessourceCraftDto toDto(RessourceCraft ressourceCraft) {
        RessourceCraftDto dto = new RessourceCraftDto();
        dto.setRessource(ressourceDtoMapper.toDto(ressourceCraft.getRessource()));
        dto.setQuantite(ressourceCraft.getQuantite());
        return dto;
    }
}
