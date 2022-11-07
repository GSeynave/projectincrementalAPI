package com.projectincremental;

import com.projectincremental.DTO.MonstreDto;
import com.projectincremental.DTO.ZoneDto;
import com.projectincremental.entities.Monstre;
import com.projectincremental.entities.Zone;

public interface EntityDtoConverter {

    ZoneDto convertEntityToDto(Zone zone);
    MonstreDto convertEntityToDto(Monstre monstre);
}
