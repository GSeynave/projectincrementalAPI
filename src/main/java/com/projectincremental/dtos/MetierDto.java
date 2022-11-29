package com.projectincremental.dtos;

public class MetierDto {

    private long id;
    private String nom;
    private long niveau;
    private long experience;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getNiveau() {
        return niveau;
    }

    public void setNiveau(long niveau) {
        this.niveau = niveau;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }
}
