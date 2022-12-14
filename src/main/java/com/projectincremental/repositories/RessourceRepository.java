package com.projectincremental.repositories;

import com.projectincremental.entities.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {

    Optional<Ressource> findById(Long ressourceId);
}
