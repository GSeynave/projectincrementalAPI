package com.projectincremental.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.projectincremental.documents.Personnage;
import com.projectincremental.dtos.PersonnageDto;

@Mapper(uses = ZoneMapper.class)
public interface PersonnageMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nom", target = "nom")
	@Mapping(source = "niveau", target = "niveau")
	@Mapping(source = "nomZone", target = "nomZone")
	public PersonnageDto personnageToPersonnageDto(Personnage personnage);
}
