package com.projectincremental.repositories;

import com.projectincremental.entities.Metier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MetierRepository extends JpaRepository<Metier, Long> {

    public Optional<List<Metier>> findAllByUserId(long userId);

}
