package com.projectincremental.services;

import com.projectincremental.entities.Zone;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ZoneService {
    List<Zone> findAll();
    Optional<Zone> findById(Long id);
}
