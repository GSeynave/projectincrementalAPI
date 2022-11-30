package com.projectincremental.repositories;

import com.projectincremental.entities.InventaireConsommable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventaireConsommableRepository extends JpaRepository<InventaireConsommable, Long> {

    Optional<List<InventaireConsommable>> findAllByUserId(Long userId);

    Optional<InventaireConsommable> findByUserIdAndConsommableId(Long id, long consommableID);
}
