package com.projectincremental.services;

import com.projectincremental.models.UserDocument;

public interface UserService {

	UserDocument findById(String userId);

	UserDocument updatePersonnageZone(String userId, String nomPersonnage, String nomZone);

	UserDocument findByUsername(String username);
}
