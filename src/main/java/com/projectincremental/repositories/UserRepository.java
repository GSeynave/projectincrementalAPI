package com.projectincremental.repositories;

import com.projectincremental.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findById(Long userId);

    public Optional<User> findByUsername(String username);
}
