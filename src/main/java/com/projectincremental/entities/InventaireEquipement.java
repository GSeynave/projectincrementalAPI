package com.projectincremental.entities;

import javax.persistence.*;

@Entity
public class InventaireEquipement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    private Long quantite;

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipment;
}
