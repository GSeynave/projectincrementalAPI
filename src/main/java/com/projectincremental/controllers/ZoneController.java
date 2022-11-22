package com.projectincremental.controllers;

import com.projectincremental.DTO.ErrorMessage;
import com.projectincremental.DTO.ZoneDto;
import com.projectincremental.DTO.mapper.ZoneMapper;
import com.projectincremental.entities.Zone;
import com.projectincremental.services.ZoneService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/zones", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZoneController {

    Logger logger = LoggerFactory.getLogger(ZoneController.class);
    @Autowired
    private ZoneMapper mapper;
    @Autowired
    private ZoneService zoneService;


    @ApiOperation(value = "Request for a Zone")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Zone not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ZoneDto> getZoneById(@PathVariable Long id) {
            logger.info("Accessing api/zones/" +id);
            Optional<Zone> zone = this.zoneService.findById(id);
            if (zone.isPresent()) {
                ZoneDto zoneDto = mapper.zoneToZoneDto(zone.get());
                return new ResponseEntity<>(zoneDto, HttpStatus.OK);
            } else {
                throw new EntityNotFoundException("Zone note found for id: " +id);
            }
    }

    @ApiOperation(value = "Request for all Zones")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Zone not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @GetMapping("")
    public ResponseEntity<List<ZoneDto>> getAll() {
        logger.info("Accessing api/zones/");
        List<Zone> zones = this.zoneService.findAll();
        if (zones.size() > 0) {
            List<ZoneDto> zonesDto = zones.stream().map(zone -> mapper.zoneToZoneDto(zone)).collect(Collectors.toList());
            return new ResponseEntity<>(zonesDto, HttpStatus.OK);
        } else {
            throw new EntityNotFoundException("Zones not found");
        }
    }
}
