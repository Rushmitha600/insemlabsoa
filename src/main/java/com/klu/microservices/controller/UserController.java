package com.klu.microservices.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.microservices.dto.UserResponse;
import com.klu.microservices.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getByUsername(
            @PathVariable String username) {

        return repository.findByUsername(username)
                .map(user -> ResponseEntity.ok(
                    new UserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getFullName(),
                        user.getEmail()
                    )
                ))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponse> getById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> ResponseEntity.ok(
                    new UserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getFullName(),
                        user.getEmail()
                    )
                ))
                .orElse(ResponseEntity.notFound().build());
    }
}
