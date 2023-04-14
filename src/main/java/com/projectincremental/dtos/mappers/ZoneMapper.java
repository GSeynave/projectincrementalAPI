package com.projectincremental.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.projectincremental.models.ZoneDocument;
import com.projectincremental.models.dtos.ZoneDto;

@Mapper
public interface ZoneMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nom", target = "nom")
	@Mapping(source = "monstres", target = "monstres")
	public ZoneDto zoneToZoneDto(ZoneDocument zone);
}
