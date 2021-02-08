package com.wild.backend.service;

import com.wild.backend.enitity.Licenses;
import com.wild.backend.repository.LicensesRepository;
import com.wild.backend.repository.ProductRepository;
import com.wild.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LicensesService {

    private LicensesRepository licensesRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    public LicensesService(LicensesRepository licensesRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.licensesRepository = licensesRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<Licenses> allLicenses(){
        return licensesRepository.findAll();
    }

    @Transactional
    public Boolean activateLicenseKey(String key){
        Licenses licenses = licensesRepository.findLicensesByLicensesKey(key);
        licensesRepository.setLicenseKeyToActive(key);
        licensesRepository.save(licenses);
        return licenses.getIsActivated();
    }

    public Boolean findLicenseKeyStatus(String licenseKey){
        Licenses licenses = licensesRepository.findLicensesByLicensesKey(licenseKey);
        return licenses.getIsActivated();
    }
    public List<Licenses> licensesByUsername(String username){
        return licensesRepository.findalllicensesbyusername(username, true);
    }
}
