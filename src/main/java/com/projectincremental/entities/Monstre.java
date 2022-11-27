package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity
public class Monstre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nom;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caracteristique_id", referencedColumnName = "id", nullable = false)
	private Caracteristique caracteristique;

	@ManyToOne
	@JoinColumn(name = "zone_id", nullable = false)
	private Zone zone;
	@OneToMany(mappedBy = "monstre")
	private Set<Ressource> ressources;

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
	public Caracteristique getStatistique() {
		return caracteristique;
	}
	public void setStatistique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}

}
