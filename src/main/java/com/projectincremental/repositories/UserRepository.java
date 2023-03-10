package com.projectincremental.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectincremental.documents.UserDocument;

public interface UserRepository extends MongoRepository<UserDocument, Long> {
}
