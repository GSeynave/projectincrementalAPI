package com.projectincremental.DTO.mapper;

import com.projectincremental.DTO.ZoneDto;
import com.projectincremental.entities.Zone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ZoneMapper {

    ZoneMapper INSTANCE = Mappers.getMapper(ZoneMapper.class);

    ZoneDto zoneToZoneDto(Zone zone);
}