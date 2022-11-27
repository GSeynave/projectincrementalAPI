package com.projectincremental.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RessourceCraft {

	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "consommable_id", referencedColumnName = "id")
	private Consommable consommable;
	@ManyToOne
	@JoinColumn(name = "equipement_id", referencedColumnName = "id")
	private Equipement equipement;
	@ManyToOne
	@JoinColumn(name = "ressource_id", referencedColumnName = "id")
	Ressource ressource;
	private Long quantite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Consommable getConsommable() {
		return consommable;
	}

	public void setConsommable(Consommable consommable) {
		this.consommable = consommable;
	}

	public Equipement getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public Long getQuantite() {
		return quantite;
	}

	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}
}
