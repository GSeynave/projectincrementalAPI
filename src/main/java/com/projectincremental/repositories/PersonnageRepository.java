package com.projectincremental.repositories;

import com.projectincremental.entities.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonnageRepository extends JpaRepository<Personnage, Long> {

    Optional<List<Personnage>> findAllByUserId(Long userId);
    Optional<Personnage> findById(Long personnageId);
}
