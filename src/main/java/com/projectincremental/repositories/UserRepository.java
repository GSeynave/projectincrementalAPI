package com.projectincremental.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectincremental.documents.UserDocument;

public interface UserRepository extends MongoRepository<UserDocument, Long> {

	Optional<UserDocument> findById(String userId);
}
