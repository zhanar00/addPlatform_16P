package com.example.buysell.repositories;

import com.example.buysell.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for User entity with basic CRUD methods
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom method to find a user by email
    User findByEmail(String email);
}
