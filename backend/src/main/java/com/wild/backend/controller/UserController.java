package com.wild.backend.controller;

import com.wild.backend.enitity.User;
import com.wild.backend.enitity.dto.UserDTO;
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
    public UserDTO user(@AuthenticationPrincipal User user) {
        return new UserDTO(user);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        if (userRepository.existsByUsername(user.getUsername())){
            return ":(";
        }
        userService.addUser(user);
        return ":)";
    }
}
