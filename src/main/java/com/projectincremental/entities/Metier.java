package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Metier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private Long niveau;
	private Long experience;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(mappedBy = "metier")
	private Set<Equipement> equipements;
	@OneToMany(mappedBy = "metier")
	private Set<Consommable> consommables;

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

	public Long getExperience() {
		return experience;
	}

	public void setExperience(Long experience) {
		this.experience = experience;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(Set<Equipement> equipements) {
		this.equipements = equipements;
	}

	public Set<Consommable> getConsommables() {
		return consommables;
	}

	public void setConsommables(Set<Consommable> consommables) {
		this.consommables = consommables;
	}
}
