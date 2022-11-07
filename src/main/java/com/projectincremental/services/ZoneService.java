package com.projectincremental.services;

import com.projectincremental.entities.Zone;

import java.util.List;
import java.util.Optional;

public interface ZoneService {

    Optional<Zone> findById(Long zoneId);
    List<Zone> findAll();
}
