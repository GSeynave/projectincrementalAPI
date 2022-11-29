package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Username;
    private String mail;
    private byte[] password;

    @OneToMany(mappedBy = "compte")
    private Set<Personnage> personnages;

    @OneToMany(mappedBy = "compte")
    private Set<InventaireRessource> inventaireRessources;

    @OneToMany(mappedBy = "compte")
    private Set<InventaireConsommable> inventaireConsommables;

    @OneToMany(mappedBy = "compte")
    private Set<InventaireEquipement> inventaireEquipements;

    @OneToMany(mappedBy = "compte")
    private Set<Metier> metiers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public Set<Personnage> getPersonnages() {
        return personnages;
    }

    public void setPersonnages(Set<Personnage> personnages) {
        this.personnages = personnages;
    }

    public Set<InventaireRessource> getInventaireRessources() {
        return inventaireRessources;
    }

    public void setInventaireRessources(Set<InventaireRessource> inventaireRessources) {
        this.inventaireRessources = inventaireRessources;
    }

    public Set<InventaireConsommable> getInventaireConsommables() {
        return inventaireConsommables;
    }

    public void setInventaireConsommables(Set<InventaireConsommable> inventaireConsommables) {
        this.inventaireConsommables = inventaireConsommables;
    }

    public Set<InventaireEquipement> getInventaireEquipements() {
        return inventaireEquipements;
    }

    public void setInventaireEquipements(Set<InventaireEquipement> inventaireEquipements) {
        this.inventaireEquipements = inventaireEquipements;
    }

    public Set<Metier> getMetiers() {
        return metiers;
    }

    public void setMetiers(Set<Metier> metiers) {
        this.metiers = metiers;
    }
}
