package com.projectincremental.services;

import java.util.List;

import com.projectincremental.models.UserDocument;
import com.projectincremental.models.dtos.Character;

public interface UserService {

	UserDocument findById(String userId);

	UserDocument updatePersonnageZone(String username, String nomPersonnage, String nomZone);

	UserDocument findByUsername(String username);

	UserDocument createCharacters(String username, List<Character> characters);
}
