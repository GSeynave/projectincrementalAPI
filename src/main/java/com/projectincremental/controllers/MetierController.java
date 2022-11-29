package com.projectincremental.controllers;

import com.projectincremental.dtos.ErrorMessage;
import com.projectincremental.dtos.InventaireDto;
import com.projectincremental.dtos.MetierDto;
import com.projectincremental.dtos.ProgressMetier;
import com.projectincremental.dtos.mappers.MetierMapper;
import com.projectincremental.entities.Metier;
import com.projectincremental.services.MetierService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metiers")
public class MetierController {


    Logger logger = LoggerFactory.getLogger(MetierController.class);

    @Autowired
    private MetierService metierService;
    @Autowired
    private MetierMapper metierMapper;

    @ApiOperation(value = "Request for metiers")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Metier not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @GetMapping("")
    public ResponseEntity<List<MetierDto>> getMetiers() {
        logger.info("Accessing api/metiers/");
        return new ResponseEntity<>(metierService.getMetiers().stream().map(metierMapper::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @ApiOperation(value = "Request to update metier")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Metier not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @PatchMapping("/{metierId}")
    public ResponseEntity<MetierDto> updateMetier(@PathVariable("metierId") long metierId, @RequestBody ProgressMetier progressMetier) {
        logger.info("Accessing api/metiers/" +metierId);

        return new ResponseEntity<>(metierMapper.toDto(metierService.updateMetier(metierId, progressMetier)), HttpStatus.OK);
    }

}
