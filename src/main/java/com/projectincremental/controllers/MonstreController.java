package com.projectincremental.controllers;

import com.projectincremental.DTO.ErrorMessage;
import com.projectincremental.DTO.MonstreDto;
import com.projectincremental.EntityDtoConverter;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/monstres", produces = MediaType.APPLICATION_JSON_VALUE)
public class MonstreController {

    @Autowired
    private MonstreService monstreService;
    @Autowired
    private EntityDtoConverter converter;
    Logger logger = LoggerFactory.getLogger(MonstreController.class);


    @ApiOperation(value = "Request for a Monstre by zone")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Zone not found"),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @GetMapping("/{zoneId}")
    public ResponseEntity<List<MonstreDto>> getAllByZone(@PathVariable Long zoneId) {
        logger.info("Accessing api/monstres/" +zoneId);
        List<Monstre> monstres = this.monstreService.getMonstresByZoneId(zoneId);
        if (monstres.size() > 0) {
            List<MonstreDto> monstresDto = monstres.stream().map(monstre -> converter.convertEntityToDto(monstre)).collect(Collectors.toList());
            return new ResponseEntity<>(monstresDto, HttpStatus.OK);
        } else {
            throw new EntityNotFoundException("Monstres not found");
        }
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage handleErrors(EntityNotFoundException e) {
        logger.info("Entity not found", e.getMessage());
        return new ErrorMessage(e.getMessage(), "404");
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessage handleErrors(Exception e) {
        logger.info("Internal server error exception", e.getMessage());
        return new ErrorMessage(e.getMessage(), "500");
    }
}
