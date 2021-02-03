package com.wild.backend.controller;

import com.wild.backend.enitity.User;
import com.wild.backend.repository.UserRepository;
import com.wild.backend.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public User loginUser(@AuthenticationPrincipal User user) {
        return user;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        if (userRepository.existsByUsername(user.getUsername())){
            return "No entry to you";
        }
        userService.addUser(user);
        return "Welcome";
    }
}
