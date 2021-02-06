package com.wild.backend.service;

import com.wild.backend.repository.LicensesRepository;
import com.wild.backend.repository.ProductRepository;
import com.wild.backend.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class BuyService {

    private ProductRepository productRepository;
    private UserRepository userRepository;
    private LicensesRepository licensesRepository;

    public BuyService(ProductRepository productRepository, UserRepository userRepository, LicensesRepository licensesRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.licensesRepository = licensesRepository;
    }
}
