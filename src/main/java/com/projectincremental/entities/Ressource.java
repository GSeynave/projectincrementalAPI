package com.projectincremental.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ressource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private Long tauxDrop;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "zone_id", referencedColumnName = "id")
	private Zone zone;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "monstre_id", referencedColumnName = "id")
	private Monstre monstre;
	@OneToMany(mappedBy = "ressource")
	private Set<RecetteRessourceRequire> ressourcesRequired;
}
