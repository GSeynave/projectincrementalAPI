package com.projectincremental.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.projectincremental.dtos.PersonnageDto;
import com.projectincremental.models.Personnage;

@Mapper(uses = ZoneMapper.class)
public interface PersonnageMapper {

	@Mapping(source = "nom", target = "nom")
	@Mapping(source = "niveau", target = "niveau")
	@Mapping(source = "nomZone", target = "nomZone")
	public PersonnageDto personnageToPersonnageDto(Personnage personnage);
}
