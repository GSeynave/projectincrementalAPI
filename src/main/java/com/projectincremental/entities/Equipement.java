package com.projectincremental.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Equipement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private Long level;
	private Long quantite;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "statistique_id", referencedColumnName = "id")
	private Statistique statistique;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "recette_id", referencedColumnName = "id")
	private Recette recette;
}
