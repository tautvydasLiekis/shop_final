package com.wild.backend.service;

import com.wild.backend.repository.LicensesRepository;
import org.springframework.stereotype.Service;

@Service
public class LicensesService {

    private LicensesRepository licensesRepository;

    public LicensesService(LicensesRepository licensesRepository) {
        this.licensesRepository = licensesRepository;
    }
}
