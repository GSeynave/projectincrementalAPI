package com.projectincremental.services.impl;

import com.projectincremental.dtos.InventaireConsommableDto;
import com.projectincremental.dtos.InventaireDto;
import com.projectincremental.dtos.InventaireEquipementDto;
import com.projectincremental.dtos.InventaireRessourceDto;
import com.projectincremental.dtos.mappers.InventaireConsommableMapper;
import com.projectincremental.dtos.mappers.InventaireEquipementMapper;
import com.projectincremental.dtos.mappers.InventaireRessourceMapper;
import com.projectincremental.entities.InventaireConsommable;
import com.projectincremental.entities.InventaireEquipement;
import com.projectincremental.entities.InventaireRessource;
import com.projectincremental.repositories.InventaireConsommableRepository;
import com.projectincremental.repositories.InventaireEquipementRepository;
import com.projectincremental.repositories.InventaireRessourceRepository;
import com.projectincremental.services.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventaireServiceImpl implements InventaireService {

    @Autowired
    private InventaireRessourceRepository inventaireRessourceRepository;
    @Autowired
    private InventaireEquipementRepository inventaireEquipementRepository;
    @Autowired
    private InventaireConsommableRepository inventaireConsommableRepository;

    @Autowired
    private InventaireRessourceMapper inventaireRessourceMapper;
    @Autowired
    private InventaireEquipementMapper inventaireEquipementMapper;
    @Autowired
    private InventaireConsommableMapper inventaireConsommableMapper;
    @Override
    public InventaireDto getInvetaire() {
        Long compteId = 1l;
        InventaireDto inventaireDto = new InventaireDto();
        inventaireDto.setInventaireRessources(getInventaireRessources());
        inventaireDto.setInventaireEquipements(getInventaireEquipements());
        inventaireDto.setInventaireConsommables(getInventaireConsommables());
        return inventaireDto;
    }

    private List<InventaireRessourceDto> getInventaireRessources() {
        Long compteId = 1l;
        Optional<List<InventaireRessource>> inventaireRessources = this.inventaireRessourceRepository.findAllByCompteId(compteId);
        if (inventaireRessources.isPresent()) {
            return inventaireRessources.get().stream().map(inventaireRessourceMapper::toDto).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
    private List<InventaireEquipementDto> getInventaireEquipements() {
        Long compteId = 1l;
        Optional<List<InventaireEquipement>> inventaireEquipements = this.inventaireEquipementRepository.findAllByCompteId(compteId);
        if (inventaireEquipements.isPresent()) {
            return inventaireEquipements.get().stream().map(inventaireEquipementMapper::toDto).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
    private List<InventaireConsommableDto> getInventaireConsommables() {
        Long compteId = 1l;
        Optional<List<InventaireConsommable>> inventaireConsommables = this.inventaireConsommableRepository.findAllByCompteId(compteId);
        if (inventaireConsommables.isPresent()) {
            return inventaireConsommables.get().stream().map(inventaireConsommableMapper::toDto).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
