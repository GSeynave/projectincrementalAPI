package com.projectincremental.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.projectincremental.documents.UserDocument;
import com.projectincremental.dtos.UserDto;

@Mapper(uses = PersonnageMapper.class)
public interface UserMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "username", target = "username")
	@Mapping(source = "personnages", target = "personnages")
	public UserDto userToUserDto(UserDocument user);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "username", target = "username")
	@Mapping(source = "personnages", target = "personnages")
	public UserDto userDtoToUser(UserDto userDto);
}
