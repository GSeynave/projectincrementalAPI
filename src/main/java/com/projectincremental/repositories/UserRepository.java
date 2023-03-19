package com.projectincremental.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectincremental.models.UserDocument;

public interface UserRepository extends MongoRepository<UserDocument, Long> {

	Optional<UserDocument> findByUsername(String username);
}
