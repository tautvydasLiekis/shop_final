package com.wild.backend.service;

import com.wild.backend.enitity.Licenses;
import com.wild.backend.repository.LicensesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicensesService {

    private LicensesRepository licensesRepository;

    public LicensesService(LicensesRepository licensesRepository) {
        this.licensesRepository = licensesRepository;
    }

    public List<Licenses> allLicenses(){
        return licensesRepository.findAll();
    }
}
