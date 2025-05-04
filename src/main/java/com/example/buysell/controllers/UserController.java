package com.example.buysell.controllers;

import ch.qos.logback.core.model.Model;
import com.example.buysell.models.User;
import com.example.buysell.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Marks this class as a Spring MVC controller
@RequiredArgsConstructor // Automatically injects final fields via constructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login"; // Returns login page
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration"; // Returns registration page
    }

    @PostMapping("/registration")
    public String createUser(User user) {
        userService.createUser(user); // Registers new user
        return "redirect:/login"; // Redirects to login after successful registration
    }

    @GetMapping("/hello")
    public String securityUrl() {
        return "hello"; // Simple test or secured page
    }
}
