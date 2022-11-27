package com.projectincremental.services.impl;

import com.projectincremental.entities.Monstre;
import com.projectincremental.entities.Zone;
import com.projectincremental.repositories.MonstreRepository;
import com.projectincremental.services.MonstreService;
import com.projectincremental.services.ZoneService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class MonstreServiceImpl implements MonstreService {

	@Autowired
	private MonstreRepository monstreRepository;
	@Autowired
	private ZoneService zoneService;
	public Optional<List<Monstre>> getMonstresByZoneId(Long zoneId) {
		return this.monstreRepository.findByZoneId(zoneId);
	}
}