package com.projectincremental.controllers;

import com.projectincremental.dtos.*;
import com.projectincremental.dtos.mappers.InventaireConsommableMapper;
import com.projectincremental.dtos.mappers.InventaireEquipementMapper;
import com.projectincremental.dtos.mappers.InventaireRessourceMapper;
import com.projectincremental.entities.InventaireConsommable;
import com.projectincremental.entities.InventaireEquipement;
import com.projectincremental.entities.InventaireRessource;
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
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/inventaires", produces = MediaType.APPLICATION_JSON_VALUE)
public class InventaireController {

    Logger logger = LoggerFactory.getLogger(InventaireController.class);
    @Autowired
    private InventaireService inventaireService;
    @Autowired
    private InventaireRessourceMapper inventaireRessourceMapper;
    @Autowired
    private InventaireEquipementMapper inventaireEquipementMapper;
    @Autowired
    private InventaireConsommableMapper inventaireConsommableMapper;

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

    @ApiOperation(value = "Request to update ressource inventory")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Inventory not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @PutMapping("/ressources/{ressourceId}/quantite/{quantite}")
    public ResponseEntity<InventaireRessourceDto> updateInventaireRessource(@PathVariable("ressourceId") Long ressourceId,
                                                                   @PathVariable("quantite") long quantite) {
        logger.info("Accessing api/inventaires/ressources/" +ressourceId +"/quantite/" +quantite);
        Optional<InventaireRessource> inventaireRessource = inventaireService.updateInventaireRessource(ressourceId, quantite);
        InventaireRessourceDto inventaireRessourceDto = inventaireRessource.map(inventaireRessourceMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Inventory not found"));
        return new ResponseEntity<>(inventaireRessourceDto, HttpStatus.OK);
    }
    @ApiOperation(value = "Request to update equipment inventory")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Inventory not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @PutMapping("/equipements/{equipementId}/personnages/{personnageId}/quantite/{quantite}")
    public ResponseEntity<InventaireEquipementDto> updateInventaireEquipement(@PathVariable("equipementId") long equipementId,
                                                              @PathVariable("personnageId") long personnageId,
                                                              @PathVariable("quantite") long quantite) {
        logger.info("Accessing api/inventaires/equipements/" +equipementId +"/personnages/" +personnageId +"quantite/" +quantite);
        Optional<InventaireEquipement> inventaireEquipement = inventaireService.updateInventaireEquipement(equipementId, personnageId, quantite);
        InventaireEquipementDto inventaireEquipementDto = inventaireEquipement.map(inventaireEquipementMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Inventory not found"));
        return new ResponseEntity<>(inventaireEquipementDto, HttpStatus.OK);
    }
    @ApiOperation(value = "Request to update consummable inventory")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Inventory not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @PutMapping("/consommables/{consommableId}/quantite/{quantite}")
    public ResponseEntity<InventaireConsommableDto> updateInventaireEquipement(@PathVariable("consommableId") long consommableId,
                                                                              @PathVariable("quantite") long quantite) {
        logger.info("Accessing api/inventaires/consommables/" +consommableId +"/quantite/" +quantite);
        Optional<InventaireConsommable> inventaireConsommable = inventaireService.updateInventaireConsommable(consommableId, quantite);
        InventaireConsommableDto inventaireConsommableDto = inventaireConsommable.map(inventaireConsommableMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Inventory not found"));
        return new ResponseEntity<>(inventaireConsommableDto, HttpStatus.OK);
    }
}
