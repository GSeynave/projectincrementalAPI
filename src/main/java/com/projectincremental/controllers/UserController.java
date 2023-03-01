package com.projectincremental.controllers;

import java.util.Objects;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectincremental.documents.UserDocument;
import com.projectincremental.dtos.ErrorMessage;
import com.projectincremental.dtos.UserDto;
import com.projectincremental.dtos.mappers.PersonnageMapper;
import com.projectincremental.dtos.mappers.UserMapper;
import com.projectincremental.exceptions.EntityNotFoundException;
import com.projectincremental.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	private final UserMapper mapper = Mappers.getMapper(UserMapper.class);
	private final PersonnageMapper personnageMapper = Mappers.getMapper(PersonnageMapper.class);
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Request all personnages")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Personnage not found"),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class) })
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable(required = true) String userId) {
		logger.info("Accessing api/users/{}", userId);

		UserDocument user = userService.findById(userId);
		if (Objects.nonNull(user)) {
			return new ResponseEntity<>(mapper.userToUserDto(user), HttpStatus.OK);
		} else {
			throw new EntityNotFoundException("Aucun user trouve");
		}
	}

	@ApiOperation(value = "Request to set the zone of a personnage")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Personnage not found"),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class) })
	@PutMapping("/{userId}/personnages/{nomPersonnage}/nomZone/{nomZone}")
	public ResponseEntity<UserDto> updateZone(@PathVariable(required = true) String userId,
			@PathVariable(required = true) String nomPersonnage, @PathVariable(required = true) String nomZone) {
		logger.info("Accessing api/users/{}/personnages/{}/nomZone/{}", userId, nomPersonnage, nomZone);

		UserDocument userDocument = userService.updatePersonnageZone(userId, nomPersonnage, nomZone);
		if (Objects.nonNull(userDocument)) {
			return new ResponseEntity<>(mapper.userToUserDto(userDocument), HttpStatus.OK);
		} else {
			throw new EntityNotFoundException("Error whilde updating personnage zone");
		}
	}
}
