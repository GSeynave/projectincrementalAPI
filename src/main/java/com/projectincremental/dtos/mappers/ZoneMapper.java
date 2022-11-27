package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.ZoneDto;
import com.projectincremental.entities.Zone;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ZoneMapper {

    public ZoneDto toDto(Zone zone) {
        ZoneDto dto = new ZoneDto();
        dto.setId(zone.getId());
        dto.setNom(zone.getNom());
        return dto;
    }
}
