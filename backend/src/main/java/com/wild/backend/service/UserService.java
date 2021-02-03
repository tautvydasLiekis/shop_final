package com.wild.backend.service;

import com.wild.backend.enitity.Role;
import com.wild.backend.enitity.User;
import com.wild.backend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findWithRolesByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    public User addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(new Role(1L,"USER")));
        return userRepository.save(user);
    }
}
