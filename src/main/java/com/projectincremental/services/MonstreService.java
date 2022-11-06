package com.projectincremental.services;

import java.util.List;

import com.projectincremental.entities.Monstre;

public interface MonstreService {

	public List<Monstre> getMonstresByZoneId(Long zoneId);
}
