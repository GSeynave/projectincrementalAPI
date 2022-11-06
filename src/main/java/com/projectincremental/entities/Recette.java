package com.projectincremental.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recette {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long niveau;
	@OneToMany(mappedBy = "recette")
	private Set<RecetteRessourceRequire> ressourcesRequired;
	@OneToOne(mappedBy = "recette")
	private Equipement equipement;

}
