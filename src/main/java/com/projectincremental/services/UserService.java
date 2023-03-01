package com.projectincremental.services;

import com.projectincremental.documents.UserDocument;

public interface UserService {

	UserDocument findById(String userId);

	UserDocument updatePersonnageZone(String userId, String nomPersonnage, String nomZone);
}
