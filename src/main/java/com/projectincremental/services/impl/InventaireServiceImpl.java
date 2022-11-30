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
import com.projectincremental.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private UserServiceImpl userService;
    @Autowired
    private PersonnageService personnageService;
    @Autowired
    private EquipementService equipementService;
    @Autowired
    private ConsommableService consommableService;

    @Autowired
    private InventaireRessourceMapper inventaireRessourceMapper;
    @Autowired
    private InventaireEquipementMapper inventaireEquipementMapper;
    @Autowired
    private InventaireConsommableMapper inventaireConsommableMapper;
    @Override
    public InventaireDto getInvetaire() {
        Long userId = 1l;
        InventaireDto inventaireDto = new InventaireDto();
        inventaireDto.setInventaireRessources(getInventaireRessources());
        inventaireDto.setInventaireEquipements(getInventaireEquipements());
        inventaireDto.setInventaireConsommables(getInventaireConsommables());
        return inventaireDto;
    }

    private List<InventaireRessourceDto> getInventaireRessources() {
        Long userId = 1l;
        Optional<List<InventaireRessource>> inventaireRessources = this.inventaireRessourceRepository.findAllByUserId(userId);
        if (inventaireRessources.isPresent()) {
            return inventaireRessources.get().stream().map(inventaireRessourceMapper::toDto).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
    private List<InventaireEquipementDto> getInventaireEquipements() {
        Long userId = 1l;
        Optional<List<InventaireEquipement>> inventaireEquipements = this.inventaireEquipementRepository.findAllByUserId(userId);
        if (inventaireEquipements.isPresent()) {
            return inventaireEquipements.get().stream().map(inventaireEquipementMapper::toDto).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
    private List<InventaireConsommableDto> getInventaireConsommables() {
        Long userId = 1l;
        Optional<List<InventaireConsommable>> inventaireConsommables = this.inventaireConsommableRepository.findAllByUserId(userId);
        if (inventaireConsommables.isPresent()) {
            return inventaireConsommables.get().stream().map(inventaireConsommableMapper::toDto).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public Optional<InventaireRessource> updateInventaireRessource(long ressourceId, long quantite) {

        Long userId = 1L;
        User user = userService.findById(userId);

        Optional<InventaireRessource> inventaireRessource = inventaireRessourceRepository.findByUserIdAndRessourceId(user.getId(), ressourceId);

        if (inventaireRessource.isPresent()) {
            inventaireRessource.get().setQuantite(inventaireRessource.get().getQuantite() + quantite);
            return Optional.ofNullable(inventaireRessourceRepository.save(inventaireRessource.get()));
        } else {
            Ressource ressource = ressourceService.findById(ressourceId);
            InventaireRessource inventaire = new InventaireRessource();
            inventaire.setRessource(ressource);
            inventaire.setUser(user);
            inventaire.setQuantite(quantite);
            return Optional.ofNullable(inventaireRessourceRepository.save(inventaire));
        }
    }

    @Override
    @Transactional
    public Optional<InventaireEquipement> updateInventaireEquipement(long equipementId, long personnageId, long quantite) {

        Long userId = 1L;
        User user = userService.findById(userId);

        Personnage personnage = personnageService.findById(personnageId);

        Optional<InventaireEquipement> inventaireEquipement = inventaireEquipementRepository.findByUserIdAndPersonnageIdAndEquipementId(user.getId(), personnage.getId(), equipementId);

        if (inventaireEquipement.isPresent()) {
            inventaireEquipement.get().setQuantite(inventaireEquipement.get().getQuantite() + quantite);
            return Optional.ofNullable(inventaireEquipementRepository.save(inventaireEquipement.get()));
        } else {
            Equipement equipement = equipementService.findById(equipementId);
            InventaireEquipement inventaire = new InventaireEquipement();
            inventaire.setEquipement(equipement);
            inventaire.setUser(user);
            inventaire.setPersonnage(personnage);
            inventaire.setQuantite(quantite);
            return Optional.ofNullable(inventaireEquipementRepository.save(inventaire));
        }
    }

    @Override
    @Transactional
    public Optional<InventaireConsommable> updateInventaireConsommable(long consommableID, long quantite) {

        Long userId = 1L;
        User user = userService.findById(userId);

        Optional<InventaireConsommable> inventaireConsommable = inventaireConsommableRepository.findByUserIdAndConsommableId(user.getId(), consommableID);

        if (inventaireConsommable.isPresent()) {
            inventaireConsommable.get().setQuantite(inventaireConsommable.get().getQuantite() + quantite);
            return Optional.ofNullable(inventaireConsommableRepository.save(inventaireConsommable.get()));
        } else {
            Consommable consommable = consommableService.findById(consommableID);
            InventaireConsommable inventaire = new InventaireConsommable();
            inventaire.setConsommable(consommable);
            inventaire.setUser(user);
            inventaire.setQuantite(quantite);
            return Optional.ofNullable(inventaireConsommableRepository.save(inventaire));
        }
    }

    @Override
    public Optional<List<InventaireEquipement>> findByPersonnageId(long personnageId) {
        return inventaireEquipementRepository.findByPersonnageId(personnageId);
    }
}
