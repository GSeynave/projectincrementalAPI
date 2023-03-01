package com.projectincremental.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectincremental.documents.ZoneDocument;


public interface ZoneRepository extends MongoRepository<ZoneDocument, Long> {

	List<ZoneDocument> findAll();
	Optional<ZoneDocument> findById(Long zoneId);

}
