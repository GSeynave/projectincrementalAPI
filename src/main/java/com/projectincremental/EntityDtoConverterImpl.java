package com.projectincremental;

import com.projectincremental.DTO.MonstreDto;
import com.projectincremental.DTO.ZoneDto;
import com.projectincremental.entities.Monstre;
import com.projectincremental.entities.Zone;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverterImpl implements EntityDtoConverter{


    @Override
    public ZoneDto convertEntityToDto(Zone zone) {
        ZoneDto zoneDto = new ZoneDto();
        zoneDto.setId(zone.getId());
        zoneDto.setNom(zone.getNom());
        return zoneDto;
    }

    @Override
    public MonstreDto convertEntityToDto(Monstre monstre) {
        MonstreDto monstreDto = new MonstreDto();
        monstreDto.setId(monstre.getId());
        monstreDto.setNom(monstre.getNom());
        monstreDto.setStatistiqueId(monstre.getStatistique().getId());
        monstreDto.setZoneId(monstre.getZone().getId());
        return monstreDto;
    }
}
