package com.wild.backend.service;

import com.wild.backend.enitity.Role;
import com.wild.backend.enitity.User;
import com.wild.backend.repository.RoleRepository;
import com.wild.backend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findWithRolesByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.getOne(1L);
        user.addRole(role);
        return userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    public User getById(long id){
        return userRepository.findUserById(id);
    }
}
