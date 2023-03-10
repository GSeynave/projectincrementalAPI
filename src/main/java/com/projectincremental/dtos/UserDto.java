package com.projectincremental.dtos;

import java.util.List;

import org.bson.types.ObjectId;

import com.projectincremental.documents.Personnage;

public class UserDto {

	private ObjectId id;
	private String username;
	private List<Personnage> personnages;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Personnage> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}

}
