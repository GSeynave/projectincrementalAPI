package com.projectincremental.repositories;

import com.projectincremental.entities.Zone;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


public interface ZoneRepository extends Repository<Zone, Long> {

	List<Zone> findAll();
	Optional<Zone> findById(Long zoneId);

}
