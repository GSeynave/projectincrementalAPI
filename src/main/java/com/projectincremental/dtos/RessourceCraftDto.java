package com.projectincremental.dtos;

public class RessourceCraftDto {
    private Long id;
    private RessourceDto ressource;
    private Long quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RessourceDto getRessource() {
        return ressource;
    }

    public void setRessource(RessourceDto ressource) {
        this.ressource = ressource;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }
}
