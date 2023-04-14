package com.projectincremental.models.dtos;

import java.util.List;

import org.bson.types.ObjectId;

import com.projectincremental.models.Personnage;

public class UserDto {

	private ObjectId id;
	private String username;
	private String email;
	private List<Personnage> personnages;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
