package com.wild.backend.service;

import com.wild.backend.enitity.Licenses;
import com.wild.backend.enitity.Product;
import com.wild.backend.enitity.User;
import com.wild.backend.repository.LicensesRepository;
import com.wild.backend.repository.ProductRepository;
import com.wild.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Properties;


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

    public String getCheckout(String username, String productName){
        User user = userRepository.findByUsername(username);
        Product product = productRepository.findByName(productName);
        Licenses licenses = new Licenses();
        user.getProducts().add(product);
        product.getUsers().add(user);
        licenses.setLicensesKey(licenses.newLicenseKey());
        return licenses.getLicensesKey();
    }
}
