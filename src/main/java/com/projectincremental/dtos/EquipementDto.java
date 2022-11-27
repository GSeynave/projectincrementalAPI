package com.projectincremental.dtos;

import com.projectincremental.entities.RessourceCraft;

import java.util.List;

public class EquipementDto {

    private Long id;
    private String nom;
    private Long niveau;
    private CaracteristiqueDto caracteristique;
    private List<RessourceCraftDto> ressourcesCraft;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getNiveau() {
        return niveau;
    }

    public void setNiveau(Long niveau) {
        this.niveau = niveau;
    }

    public CaracteristiqueDto getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(CaracteristiqueDto caracteristique) {
        this.caracteristique = caracteristique;
    }

    public List<RessourceCraftDto> getRessourcesCraft() {
        return ressourcesCraft;
    }

    public void setRessourcesCraft(List<RessourceCraftDto> ressourcesCraft) {
        this.ressourcesCraft = ressourcesCraft;
    }
}
