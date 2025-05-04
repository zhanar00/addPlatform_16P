package com.example.buysell.services;

import com.example.buysell.models.User;
import com.example.buysell.models.enums.Role;
import com.example.buysell.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service
@Slf4j // Enables logging
@RequiredArgsConstructor // Generates constructor for final fields
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String userEmail = user.getEmail();

        // Check if a user with this email already exists
        if (userRepository.findByEmail(userEmail) != null) return false;

        // Activate user and encode password
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Assign default user role
        user.getRoles().add(Role.ROLE_USER);

        // Log and save new user
        log.info("Saving new User with email: {}", userEmail);
        userRepository.save(user);
        return true;
    }
}
