package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.CaracteristiqueDto;
import com.projectincremental.dtos.MonstreDto;
import com.projectincremental.entities.Monstre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonstreMapper {

    @Autowired
    private CaracteristiqueMapper caracteristiqueMapper;

    public MonstreDto toDto(Monstre monstre) {
        MonstreDto dto = new MonstreDto();
        dto.setId(monstre.getId());
        dto.setNom(monstre.getNom());
        dto.setZoneId(monstre.getZone().getId());
        dto.setCaracteristique(caracteristiqueMapper.toDto(monstre.getStatistique()));
        return dto;
    }
}
