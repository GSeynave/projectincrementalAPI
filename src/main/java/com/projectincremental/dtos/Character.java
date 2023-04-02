package com.projectincremental.dtos;

import com.projectincremental.models.enums.CharacterClasses;


public class Character {

	private String characterName;
	private CharacterClasses classe;

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public CharacterClasses getClasse() {
		return classe;
	}

	public void setClasse(CharacterClasses classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "CreateCharacters [characterName=" + characterName + ", classe=" + classe + "]";
	}

}
