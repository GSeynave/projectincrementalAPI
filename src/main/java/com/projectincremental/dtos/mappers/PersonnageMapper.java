package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.PersonnageDto;
import com.projectincremental.entities.Personnage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonnageMapper {

    @Autowired
    private ZoneMapper zoneMapper;
    @Autowired
    private CaracteristiqueMapper caracteristiqueMapper;
    public PersonnageDto toDto(Personnage personnage) {
        PersonnageDto dto = new PersonnageDto();
        dto.setId(personnage.getId());
        dto.setNom(personnage.getNom());
        dto.setNiveau(personnage.getNiveau());
        dto.setZone(zoneMapper.toDto(personnage.getZone()));
        dto.setCaracteristique(caracteristiqueMapper.toDto(personnage.getCaracteristique()));
        return dto;
    }
}
