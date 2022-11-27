package com.projectincremental.controllers;

import com.projectincremental.dtos.ErrorMessage;
import com.projectincremental.dtos.InventaireDto;
import com.projectincremental.services.InventaireService;
import com.projectincremental.services.impl.InventaireServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/inventaires", produces = MediaType.APPLICATION_JSON_VALUE)
public class InventaireController {

    Logger logger = LoggerFactory.getLogger(InventaireController.class);
    @Autowired
    private InventaireService inventaireService;

    @ApiOperation(value = "Request for Inventories")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 404, message = "Inventory not found"),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @GetMapping("")
    public ResponseEntity<InventaireDto> getInventaire() {
        logger.info("Accessing api/inventaires/");
        return new ResponseEntity<>(inventaireService.getInvetaire(), HttpStatus.OK);
    }
}
