package com.projectincremental.services;

import com.projectincremental.entities.Monstre;

import java.util.List;
import java.util.Optional;

public interface MonstreService {

	Optional<List<Monstre>> getMonstresByZoneId(Long zoneId);
}
