package com.projectincremental.models;

import com.projectincremental.models.enums.CharacterClasses;

public class Personnage {

	private String nom;
	private Long niveau;
	private String nomZone;
	private CharacterClasses classe;
	private Caracteristique caracteristique;

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

	public String getNomZone() {
		return nomZone;
	}

	public void setNomZone(String nomZone) {
		this.nomZone = nomZone;
	}

	public CharacterClasses getClasse() {
		return classe;
	}

	public void setClasse(CharacterClasses classe) {
		this.classe = classe;
	}

	public Caracteristique getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}
}
