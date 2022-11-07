package com.projectincremental.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

public class Inventaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToMany
	private Set<Ressource> inventaireRessources;
	@ManyToMany
	private Set<Equipement> inventaireEquipements;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Ressource> getInventaireRessources() {
		return inventaireRessources;
	}

	public void setInventaireRessources(Set<Ressource> inventaireRessources) {
		this.inventaireRessources = inventaireRessources;
	}

	public Set<Equipement> getInventaireEquipements() {
		return inventaireEquipements;
	}

	public void setInventaireEquipements(Set<Equipement> inventaireEquipements) {
		this.inventaireEquipements = inventaireEquipements;
	}
}
