package com.projectincremental.controllers;

import com.projectincremental.dtos.CaracteristiqueDto;
import com.projectincremental.dtos.ErrorMessage;
import com.projectincremental.dtos.PersonnageDto;
import com.projectincremental.dtos.mappers.CaracteristiqueMapper;
import com.projectincremental.dtos.mappers.PersonnageMapper;
import com.projectincremental.entities.Caracteristique;
import com.projectincremental.entities.Personnage;
import com.projectincremental.services.CaracteristiqueService;
import com.projectincremental.services.PersonnageService;
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
@RequestMapping(path = "/personnages", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonnageController {

    Logger logger = LoggerFactory.getLogger(InventaireController.class);
    @Autowired
    private PersonnageService personnageService;
    @Autowired
    private CaracteristiqueService caracteristiqueService;
    @Autowired
    private PersonnageMapper personnageMapper;
    @Autowired
    private CaracteristiqueMapper caracteristiqueMapper;

    @ApiOperation(value = "Request all personnages")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Personnage not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @GetMapping("")
    public ResponseEntity<List<PersonnageDto>> getPersonnages() {
        logger.info("Accessing api/personnages/");

        Optional<List<Personnage>> personnages = personnageService.findAll();
        if (personnages.isPresent()) {
            return new ResponseEntity<>(personnages.get()
                    .stream()
                    .map(personnageMapper::toDto)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } else {
            throw new EntityNotFoundException("Aucun personnage trouve");
        }
    }

    @ApiOperation(value = "Request a personnage by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Personnage not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @GetMapping("/{personnageId}")
    public ResponseEntity<PersonnageDto> getPersonnageById(@PathVariable("personnageId") Long personnageId) {

        logger.info("Accessing api/personnages/" + personnageId);
        Optional<Personnage> personnage = personnageService.findById(personnageId);
        if (personnage.isPresent()) {
            return new ResponseEntity<>(personnageMapper.toDto(personnage.get()), HttpStatus.OK);
        } else {
            throw new EntityNotFoundException("Aucun personnage trouve pour l'id " + personnageId);
        }
    }

    @ApiOperation(value = "Request to set the zone of a personnage")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Personnage not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @PutMapping("/{personnageId}/zones/{zoneId}")
    public ResponseEntity<PersonnageDto> updateZone(@PathVariable("personnageId") Long personnageId, @PathVariable("zoneId") Long zoneId) {
        logger.info("Accessing api/personnages/"+personnageId+"/zones/"+zoneId);

        Optional<Personnage> personnage = personnageService.updateZone(personnageId, zoneId);
        if (personnage.isPresent()) {
            return new ResponseEntity<>(personnageMapper.toDto(personnage.get()), HttpStatus.OK);
        } else {
            throw new EntityNotFoundException("Error whilde updating personnage zone");
        }
    }

    @ApiOperation(value = "Request to set the caracteristique of a personnage")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Personnage not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @PutMapping("/{personnageId}/caracteristiques")
    public ResponseEntity<PersonnageDto> updateCaracteristique(@PathVariable("personnageId") Long personnageId, @RequestBody CaracteristiqueDto caracteristiqueDto) {
        logger.info("Accessing api/personnages/"+personnageId+"/caracteristique");

        Optional<Caracteristique> caracteristique = caracteristiqueService.findById(caracteristiqueDto.getId());
        if (caracteristique.isPresent()) {

            Optional<Personnage> personnage = personnageService.updateCaracteristique(personnageId, caracteristiqueMapper.toEntity(caracteristiqueDto));
            if (personnage.isPresent()) {
                return new ResponseEntity<>(personnageMapper.toDto(personnage.get()), HttpStatus.OK);
            } else {
                throw new EntityNotFoundException("Error whilde updating personnage zone");
            }
        } else {
            throw new EntityNotFoundException("Aucune caracteristique pour le personnage id " +personnageId);
        }
    }
}
