package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mail;
    private String username;
    private String password;
    private String roles;


    @OneToMany(mappedBy = "user")
    private Set<Personnage> personnages;

    @OneToMany(mappedBy = "user")
    private Set<InventaireRessource> inventaireRessources;

    @OneToMany(mappedBy = "user")
    private Set<InventaireConsommable> inventaireConsommables;

    @OneToMany(mappedBy = "user")
    private Set<InventaireEquipement> inventaireEquipements;

    @OneToMany(mappedBy = "user")
    private Set<Metier> metiers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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
