package com.projectincremental.services.impl;

import com.projectincremental.entities.Zone;
import com.projectincremental.repositories.ZoneRepository;
import com.projectincremental.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneServiceImpl implements ZoneService {


    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public Optional<Zone> findById(Long zoneId) {
        Optional<Zone> zone = this.zoneRepository.findZoneById(zoneId);
        if (zone.isPresent()) {
            return zone;
        } else {
            throw new EntityNotFoundException("Zone not found with id" +zoneId);
        }
    }

    @Override
    public List<Zone> findAll() {
        return this.zoneRepository.findAll();
    }
}
