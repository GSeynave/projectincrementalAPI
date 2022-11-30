package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Personnage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private Long niveau;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caracteristique_id", referencedColumnName = "id")
	private Caracteristique caracteristique;
	@ManyToOne
	@JoinColumn(name = "zone_id", nullable = false)
	private Zone zone;
	@OneToMany(mappedBy = "personnage")
	private Set<InventaireEquipement> inventaireEquipements;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

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

	public Caracteristique getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Set<InventaireEquipement> getInventaireEquipements() {
		return inventaireEquipements;
	}

	public void setInventaireEquipements(Set<InventaireEquipement> inventaireEquipements) {
		this.inventaireEquipements = inventaireEquipements;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
