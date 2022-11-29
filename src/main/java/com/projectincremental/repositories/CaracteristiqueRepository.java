package com.projectincremental.repositories;

import com.projectincremental.entities.Caracteristique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, Long> {

    Optional<Caracteristique> findById(Long caracteristiqueId);
}
