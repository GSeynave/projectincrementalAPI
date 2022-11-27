package com.projectincremental.dtos;

public class PersonnageDto {

    private Long id;
    private String nom;
    private Long niveau;
    private CaracteristiqueDto caracteristique;
    private ZoneDto zone;

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

    public ZoneDto getZone() {
        return zone;
    }

    public void setZone(ZoneDto zone) {
        this.zone = zone;
    }
}
