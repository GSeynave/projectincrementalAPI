package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Consommable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private Long niveau;

    @OneToMany(mappedBy = "consommable")
    private Set<InventaireConsommable> inventaireConsommables;

    @OneToMany(mappedBy = "consommable")
    private Set<RessourceCraft> ressourceCrafts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "caracteristique_id", referencedColumnName = "id")
    private Caracteristique caracteristique;
    @ManyToOne
    @JoinColumn(name = "metier_id", nullable = false)
    private Metier metier;

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

    public Set<InventaireConsommable> getInventaireConsommables() {
        return inventaireConsommables;
    }

    public void setInventaireConsommables(Set<InventaireConsommable> inventaireConsommables) {
        this.inventaireConsommables = inventaireConsommables;
    }

    public Set<RessourceCraft> getRessourceCrafts() {
        return ressourceCrafts;
    }

    public void setRessourceCrafts(Set<RessourceCraft> ressourceCrafts) {
        this.ressourceCrafts = ressourceCrafts;
    }

    public Caracteristique getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(Caracteristique caracteristique) {
        this.caracteristique = caracteristique;
    }

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }
}
