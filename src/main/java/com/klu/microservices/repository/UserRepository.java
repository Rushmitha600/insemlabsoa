package com.klu.microservices.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.microservices.dto.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
