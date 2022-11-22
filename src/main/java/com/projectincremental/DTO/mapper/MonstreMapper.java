package com.projectincremental.DTO.mapper;

import com.projectincremental.DTO.MonstreDto;
import com.projectincremental.entities.Monstre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MonstreMapper {

    MonstreMapper INSTANCE = Mappers.getMapper(MonstreMapper.class);

    MonstreDto monstreToMonstreDto(Monstre monstre);


}