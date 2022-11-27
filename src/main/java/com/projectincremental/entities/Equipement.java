package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Equipement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private Long niveau;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caracteristique_id", referencedColumnName = "id")
	private Caracteristique caracteristique;
	@OneToMany(mappedBy = "equipement")
	private Set<InventaireEquipement> inventaireEquipements;
	@OneToMany(mappedBy = "equipement")
	private Set<RessourceCraft> ressourceCrafts;
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

	public Caracteristique getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

	public Set<InventaireEquipement> getInventaireEquipements() {
		return inventaireEquipements;
	}

	public void setInventaireEquipements(Set<InventaireEquipement> inventaireEquipements) {
		this.inventaireEquipements = inventaireEquipements;
	}

	public Set<RessourceCraft> getRessourceCrafts() {
		return ressourceCrafts;
	}

	public void setRessourceCrafts(Set<RessourceCraft> ressourceCrafts) {
		this.ressourceCrafts = ressourceCrafts;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}
}
