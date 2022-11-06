package com.projectincremental.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RecetteRessourceRequire {

	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "recette_id", referencedColumnName = "id")
	Recette recette;
	
	@ManyToOne
	@JoinColumn(name = "ressource_id", referencedColumnName = "id")
	Ressource ressource;
	
	private Long quantite;

}
