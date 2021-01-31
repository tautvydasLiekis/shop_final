package com.wild.backend.controller;

import com.wild.backend.enitity.User;
import com.wild.backend.enitity.dto.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/login")
    public UserDTO user(@AuthenticationPrincipal User user) {
        return new UserDTO(user);
    }
}
