package com.projectincremental.services.impl;

import com.projectincremental.entities.SecurityUser;
import com.projectincremental.entities.User;
import com.projectincremental.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Aucun user pour l'id " +userId));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Aucun user pour le username " +username));
    }

    public void createUser(User user) {
        if (findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists " +user.getUsername());
        }
        userRepository.save(user);
    }

    private Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
