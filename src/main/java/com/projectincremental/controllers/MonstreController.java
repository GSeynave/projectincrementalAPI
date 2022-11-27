package com.projectincremental.controllers;

import com.projectincremental.dtos.ErrorMessage;
import com.projectincremental.dtos.MonstreDto;
import com.projectincremental.dtos.mappers.MonstreMapper;
import com.projectincremental.entities.Monstre;
import com.projectincremental.services.MonstreService;
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
@RequestMapping(path = "/monstres", produces = MediaType.APPLICATION_JSON_VALUE)
public class MonstreController {

    @Autowired
    private MonstreService monstreService;
    @Autowired
    private MonstreMapper mapper;
    Logger logger = LoggerFactory.getLogger(MonstreController.class);


    @ApiOperation(value = "Request for a Monstre by zone")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Monstres not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @GetMapping("/zones/{zoneId}")
    public ResponseEntity<List<MonstreDto>> getAllByZone(@PathVariable Long zoneId) {
        logger.info("Accessing api/monstres/" +zoneId);
        Optional<List<Monstre>> monstres = this.monstreService.getMonstresByZoneId(zoneId);
        if (monstres.isPresent()) {
            return new ResponseEntity<>(monstres
                    .get()
                    .stream()
                    .map(mapper::toDto)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } else {
            throw new EntityNotFoundException("Monstres not found");
        }
    }
}
