package com.projectincremental.services.impl;

import com.projectincremental.dtos.InventaireConsommableDto;
import com.projectincremental.dtos.InventaireDto;
import com.projectincremental.dtos.InventaireEquipementDto;
import com.projectincremental.dtos.InventaireRessourceDto;
import com.projectincremental.dtos.mappers.InventaireConsommableMapper;
import com.projectincremental.dtos.mappers.InventaireEquipementMapper;
import com.projectincremental.dtos.mappers.InventaireRessourceMapper;
import com.projectincremental.entities.*;
import com.projectincremental.repositories.InventaireConsommableRepository;
import com.projectincremental.repositories.InventaireEquipementRepository;
import com.projectincremental.repositories.InventaireRessourceRepository;
import com.projectincremental.services.CompteService;
import com.projectincremental.services.InventaireService;
import com.projectincremental.services.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
    private RessourceService ressourceService;
    @Autowired
    private CompteService compteService;

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

    @Override
    public Optional<InventaireRessource> updateInventaireRessource(long ressourceId, long quantite) {

        Long compteId = 1L;
        Compte compte = compteService.findById(compteId)
                .orElseThrow(() -> new EntityNotFoundException("erreur lors de la recuperation du compte"));

        Optional<InventaireRessource> inventaireRessource = inventaireRessourceRepository.findByCompteIdAndRessourceId(compte.getId(), ressourceId);

        if (inventaireRessource.isPresent()) {
            inventaireRessource.get().setQuantite(inventaireRessource.get().getQuantite() + quantite);
            return Optional.ofNullable(inventaireRessourceRepository.save(inventaireRessource.get()));
        } else {
            Ressource ressource = ressourceService.findById(ressourceId)
                    .orElseThrow(() -> new EntityNotFoundException("Impossible d'ajouter une ressource qui n'existe pas."));

            InventaireRessource inventaire = new InventaireRessource();
            inventaire.setRessource(ressource);
            inventaire.setCompte(compte);
            inventaire.setQuantite(quantite);
            return Optional.ofNullable(inventaireRessourceRepository.save(inventaire));
        }
    }
}
