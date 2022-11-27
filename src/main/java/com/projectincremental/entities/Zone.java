package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Zone {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String nom;


	@OneToMany(mappedBy = "zone")
	private Set<Personnage> personnages;

	@OneToMany(mappedBy = "zone")
	private Set<Monstre> monstres;


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
	
}
