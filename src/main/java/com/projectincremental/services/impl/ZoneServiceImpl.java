package com.projectincremental.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectincremental.documents.ZoneDocument;
import com.projectincremental.repositories.ZoneRepository;
import com.projectincremental.services.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService {

    private ZoneRepository zoneRepository;

	public ZoneServiceImpl(ZoneRepository zoneRepository) {
		super();
		this.zoneRepository = zoneRepository;
	}

	@Override
    public List<ZoneDocument> findAll() {
        return this.zoneRepository.findAll();
	}

    @Override
    public Optional<ZoneDocument> findById(Long zoneId) {
        return this.zoneRepository.findById(zoneId);
    }
}
