package com.projectincremental.repositories;

import com.projectincremental.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long> {

    public Optional<Compte> findById(Long compteId);
}
