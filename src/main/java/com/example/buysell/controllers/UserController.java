package com.example.buysell.controllers;

import ch.qos.logback.core.model.Model;
import com.example.buysell.models.User;
import com.example.buysell.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller // Marks this class as a Spring MVC controller
@RequiredArgsConstructor // Automatically injects final fields via constructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
<<<<<<< HEAD
    public String login() {
        return "login"; // Returns login page
=======
    public String login(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "login";
>>>>>>> 208c087f65538056c0602ba2aeecc5b2fef8aacc
    }

    @GetMapping("/profile")
    public String profile(Principal principal,
                          Model model) {
        User user = userService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/registration")
<<<<<<< HEAD
    public String registration() {
        return "registration"; // Returns registration page
=======
    public String registration(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "registration";
>>>>>>> 208c087f65538056c0602ba2aeecc5b2fef8aacc
    }

    @PostMapping("/registration")
<<<<<<< HEAD
    public String createUser(User user) {
        userService.createUser(user); // Registers new user
        return "redirect:/login"; // Redirects to login after successful registration
    }

    @GetMapping("/hello")
    public String securityUrl() {
        return "hello"; // Simple test or secured page
=======
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model, Principal principal) {
        model.addAttribute("user", user);
        model.addAttribute("userByPrincipal", userService.getUserByPrincipal(principal));
        model.addAttribute("products", user.getProducts());
        return "user-info";
>>>>>>> 208c087f65538056c0602ba2aeecc5b2fef8aacc
    }
}
