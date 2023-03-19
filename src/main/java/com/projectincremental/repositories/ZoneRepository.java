package com.projectincremental.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectincremental.models.ZoneDocument;


public interface ZoneRepository extends MongoRepository<ZoneDocument, Long> {

	ZoneDocument findByNom(String nom);

}
