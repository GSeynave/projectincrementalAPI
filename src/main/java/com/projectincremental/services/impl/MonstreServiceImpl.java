package com.projectincremental.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projectincremental.entities.Monstre;
import com.projectincremental.entities.Zone;
import com.projectincremental.services.MonstreService;


@Service
public class MonstreServiceImpl implements MonstreService {

	public List<Monstre> getMonstresByZoneId(Long zoneId) {
		List<Monstre> monstres = new ArrayList<>();
		Monstre monstre = new Monstre();
		monstre.setZone(new Zone());
		monstre.getZone().setId(zoneId);
		monstres.add(monstre);
		return monstres;
	}
}
