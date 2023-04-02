package com.projectincremental.services;

import java.util.List;

import com.projectincremental.dtos.Character;
import com.projectincremental.models.UserDocument;

public interface UserService {

	UserDocument findById(String userId);

	UserDocument updatePersonnageZone(String userId, String nomPersonnage, String nomZone);

	UserDocument findByUsername(String username);

	UserDocument createCharacters(String username, List<Character> characters);
}
