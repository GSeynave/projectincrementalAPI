package com.projectincremental.documents;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("zone")
public class ZoneDocument {

	@MongoId(FieldType.OBJECT_ID)
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
