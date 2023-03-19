package com.projectincremental.services;

import java.util.List;

import com.projectincremental.models.ZoneDocument;

public interface ZoneService {
    List<ZoneDocument> findAll();

	ZoneDocument findByNom(String nom);
}
