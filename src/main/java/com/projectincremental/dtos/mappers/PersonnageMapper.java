package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.CaracteristiqueDto;
import com.projectincremental.dtos.PersonnageDto;
import com.projectincremental.entities.Personnage;
import com.projectincremental.services.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonnageMapper {

    @Autowired
    private ZoneMapper zoneMapper;
    @Autowired
    private CaracteristiqueMapper caracteristiqueMapper;
    @Autowired
    private PersonnageService personnageService;
    public PersonnageDto toDto(Personnage personnage) {
        PersonnageDto dto = new PersonnageDto();
        dto.setId(personnage.getId());
        dto.setNom(personnage.getNom());
        dto.setNiveau(personnage.getNiveau());
        dto.setZone(zoneMapper.toDto(personnage.getZone()));
        dto.setCaracteristiquePersonnage(caracteristiqueMapper.toDto(personnage.getCaracteristique()));
        dto.setCaracteristiqueEquipement(getCaracteristiqueEquipement(personnage.getId()));
        return dto;
    }

    private CaracteristiqueDto getCaracteristiqueEquipement(long id) {
        return caracteristiqueMapper.toDto(
                personnageService.getCaracteristiqueEquipements(id)
        );
    }
}
