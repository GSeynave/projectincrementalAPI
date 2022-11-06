package com.projectincremental.entities;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class Inventaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.AUTO)
	private Long id;
	@ManyToMany
	private Set<Ressource> inventaireRessources;
	@ManyToMany
	private Set<Equipement> inventaireEquipements;
}
