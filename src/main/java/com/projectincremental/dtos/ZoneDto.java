package com.projectincremental.dtos;

import java.util.List;

import com.projectincremental.models.Monstre;

public class ZoneDto {

	private String id;
    private String nom;
	private List<Monstre> monstres;

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

	public List<Monstre> getMonstres() {
		return monstres;
	}

	public void setMonstres(List<Monstre> monstres) {
		this.monstres = monstres;
	}

}
