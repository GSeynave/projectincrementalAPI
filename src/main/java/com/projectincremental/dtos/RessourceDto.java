package com.projectincremental.dtos;

public class RessourceDto {

    private Long id;
    private String nom;
    private Long tauxDrop;

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

    public Long getTauxDrop() {
        return tauxDrop;
    }

    public void setTauxDrop(Long tauxDrop) {
        this.tauxDrop = tauxDrop;
    }
}
