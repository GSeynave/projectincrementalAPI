package com.projectincremental.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.projectincremental.entities.Monstre;
import com.projectincremental.entities.Zone;

public interface MonstreRepository extends Repository<Monstre, Long>{

	Optional<List<Monstre>> findByZoneId(Long zoneId);
}
