package com.projectincremental.services;

import java.util.List;
import java.util.Optional;

import com.projectincremental.documents.ZoneDocument;

public interface ZoneService {
    List<ZoneDocument> findAll();
    Optional<ZoneDocument> findById(Long id);
}
