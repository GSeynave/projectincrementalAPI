package com.projectincremental.DTO;

public class MonstreDto {

    private Long id;
    private String nom;
    private Long statistiqueId;
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

    public Long getStatistiqueId() {
        return statistiqueId;
    }

    public void setStatistiqueId(Long statistiqueId) {
        this.statistiqueId = statistiqueId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
}
