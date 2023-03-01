package com.projectincremental.dtos;

import java.util.List;

import com.projectincremental.documents.Personnage;

public class UserDto {

	private String id;
	private String username;
	private List<Personnage> personnages;
    private ZoneDto zone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public ZoneDto getZone() {
		return zone;
	}

	public void setZone(ZoneDto zone) {
		this.zone = zone;
	}

}
