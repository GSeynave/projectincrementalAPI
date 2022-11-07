package com.projectincremental.services;

import com.projectincremental.entities.Monstre;

import java.util.List;

public interface MonstreService {

	List<Monstre> getMonstresByZoneId(Long zoneId) throws Exception;
}
