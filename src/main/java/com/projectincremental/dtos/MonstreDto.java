package com.projectincremental.dtos;

public class MonstreDto {

    private Long id;
    private String nom;
    private CaracteristiqueDto caracteristique;
    private Long zoneId;

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

    public CaracteristiqueDto getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(CaracteristiqueDto caracteristiqueDto) {
        this.caracteristique = caracteristiqueDto;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
}
