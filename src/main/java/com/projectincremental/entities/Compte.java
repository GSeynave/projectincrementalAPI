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
}
