package com.wild.backend.service;

import com.wild.backend.repository.ProductRepository;
import com.wild.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyService {

    private UserRepository userRepository;
    private ProductRepository productRepository;

}
