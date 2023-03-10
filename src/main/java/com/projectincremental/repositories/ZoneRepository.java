package com.projectincremental.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectincremental.documents.ZoneDocument;


public interface ZoneRepository extends MongoRepository<ZoneDocument, Long> {

}
