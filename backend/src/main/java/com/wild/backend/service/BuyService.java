package com.wild.backend.service;

import com.wild.backend.enitity.Licenses;
import com.wild.backend.enitity.Product;
import com.wild.backend.enitity.User;
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

    public String getCheckout(String name1, String name2){
        Licenses licenses = new Licenses();
        Product product = productRepository.findProductByName(name1);
        User user = userRepository.findUserByUsername(name2);
        licenses.setProductId(product.getId());
        licenses.setUserId(user.getId());
        licenses.setLicensesKey(licenses.newLicenseKey());
        licenses.setIsActivated(false);
        licensesRepository.saveAndFlush(licenses);
        return licenses.getLicensesKey();
    }
}
