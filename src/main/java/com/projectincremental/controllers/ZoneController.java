package com.projectincremental.controllers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectincremental.dtos.mappers.ZoneMapper;
import com.projectincremental.exceptions.EntityNotFoundException;
import com.projectincremental.models.ZoneDocument;
import com.projectincremental.models.dtos.ErrorMessage;
import com.projectincremental.models.dtos.ZoneDto;
import com.projectincremental.services.ZoneService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "api/v1/zones", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZoneController {

	private final Logger logger = LoggerFactory.getLogger(ZoneController.class);
	private final ZoneMapper zoneMapper = Mappers.getMapper(ZoneMapper.class);

	@Autowired
	private ZoneService zoneService;

	@ApiOperation(value = "Request for all Zones")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 404, message = "Zone not found"),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class) })
	@GetMapping("")
	public ResponseEntity<List<ZoneDto>> getAll() {
		logger.info("Accessing api/zones/");
		List<ZoneDocument> zones = this.zoneService.findAll();
		if (zones.size() > 0) {
			List<ZoneDto> zonesDto = zones.stream().map(zoneMapper::zoneToZoneDto).collect(Collectors.toList());
			return new ResponseEntity<>(zonesDto, HttpStatus.OK);
		} else {
			throw new EntityNotFoundException("Aucunes zone n'a ete trouvee");
		}
	}

	@ApiOperation(value = "Retrieve a zone by it's name")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 404, message = "Zone not found"),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class) })
	@GetMapping("/{nom}")
	public ResponseEntity<ZoneDto> getZoneByNom(@PathVariable String nom) {
		logger.info("Accessing api/zones/{nom}");
		ZoneDocument zone = this.zoneService.findByNom(nom);
		if (Objects.nonNull(zone)) {
			ZoneDto zoneDto = zoneMapper.zoneToZoneDto(zone);
			return new ResponseEntity<>(zoneDto, HttpStatus.OK);
		} else {
			throw new EntityNotFoundException("Aucunes zone n'a ete trouvee");
		}
	}
}
