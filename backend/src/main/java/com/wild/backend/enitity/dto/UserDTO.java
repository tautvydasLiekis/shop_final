package com.wild.backend.enitity.dto;

import com.wild.backend.enitity.Product;
import com.wild.backend.enitity.Role;
import com.wild.backend.enitity.User;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String name;
    private String lastname;
    private String password;
    private Set<String> roles;
    private List<String> products;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.password = user.getPassword();
        this.roles = user.getRoles().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet());
        this.products = user.getProducts().stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }
}
