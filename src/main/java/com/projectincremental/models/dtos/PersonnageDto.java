package com.projectincremental.models.dtos;

public class PersonnageDto {

	private String id;
    private String nom;
    private Long niveau;
	private String nomZone;

	public String getId() {
        return id;
    }

	public void setId(String id) {
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

	public String getNomZone() {
		return nomZone;
	}

	public void setNomZone(String nomZone) {
		this.nomZone = nomZone;
	}

}
