package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ressource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private Long tauxDrop;
	@ManyToOne
	@JoinColumn(name = "monstre_id")
	private Monstre monstre;
	@ManyToOne
	@JoinColumn(name = "metier_id")
	private Metier metier;
	@OneToMany(mappedBy = "ressource")
	private Set<InventaireRessource> inventaireRessources;
	@OneToMany(mappedBy = "ressource")
	private Set<RessourceCraft> ressourceCrafts;

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

	public Long getTauxDrop() {
		return tauxDrop;
	}

	public void setTauxDrop(Long tauxDrop) {
		this.tauxDrop = tauxDrop;
	}

	public Monstre getMonstre() {
		return monstre;
	}

	public void setMonstre(Monstre monstre) {
		this.monstre = monstre;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	public Set<InventaireRessource> getInventaireRessources() {
		return inventaireRessources;
	}

	public void setInventaireRessources(Set<InventaireRessource> inventaireRessources) {
		this.inventaireRessources = inventaireRessources;
	}

	public Set<RessourceCraft> getRessourceCrafts() {
		return ressourceCrafts;
	}

	public void setRessourceCrafts(Set<RessourceCraft> ressourceCrafts) {
		this.ressourceCrafts = ressourceCrafts;
	}
}
