package com.projectincremental.repositories;

import com.projectincremental.entities.Consommable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsommableRepository extends JpaRepository<Consommable, Long> {

    public Optional<Consommable> findById(long consommableId);
}
