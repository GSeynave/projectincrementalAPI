package com.projectincremental.controllers;

import java.util.List;
import java.util.Objects;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectincremental.dtos.Character;
import com.projectincremental.dtos.ErrorMessage;
import com.projectincremental.dtos.UserDto;
import com.projectincremental.dtos.mappers.UserMapper;
import com.projectincremental.exceptions.EntityNotFoundException;
import com.projectincremental.models.UserDocument;
import com.projectincremental.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	private final UserMapper mapper = Mappers.getMapper(UserMapper.class);
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Request user by username")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Personnage not found"),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class) })
	@GetMapping("/{username}")
	public ResponseEntity<UserDto> getUser(@PathVariable String username) {
		logger.info("Accessing api/users/{}", username);

		UserDocument user = userService.findByUsername(username);
		if (Objects.nonNull(user)) {
			return new ResponseEntity<>(mapper.userToUserDto(user), HttpStatus.OK);
		} else {
			throw new EntityNotFoundException("Aucun user trouve");
		}
	}

	@ApiOperation(value = "Creation of characters")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 204, message = "Personnage user updated"),
			@ApiResponse(code = 404, message = "No user found"),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class) })
	@PostMapping("/{username}/createcharacters")
	public ResponseEntity<UserDto> createCharacters(@PathVariable(required = true) String username,
			@RequestBody List<Character> characters) {
		logger.info("Accessing api/users/{}/createCharacters {}", username, characters.toString());

		UserDocument userDocument = userService.createCharacters(username, characters);
		if (Objects.nonNull(userDocument)) {
			return new ResponseEntity<>(mapper.userToUserDto(userDocument), HttpStatus.OK);
		} else {
			throw new EntityNotFoundException("Error whilde updating personnage zone");
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
