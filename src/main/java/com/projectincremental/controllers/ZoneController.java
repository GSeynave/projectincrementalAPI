package com.projectincremental.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectincremental.documents.ZoneDocument;
import com.projectincremental.dtos.ErrorMessage;
import com.projectincremental.dtos.ZoneDto;
import com.projectincremental.dtos.mappers.ZoneMapper;
import com.projectincremental.exceptions.EntityNotFoundException;
import com.projectincremental.services.ZoneService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/zones", produces = MediaType.APPLICATION_JSON_VALUE)
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
}
