package com.wild.backend.controller;

import com.wild.backend.enitity.Licenses;
import com.wild.backend.repository.LicensesRepository;
import com.wild.backend.service.LicensesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicensesController {

    private LicensesService licensesService;
    private LicensesRepository licensesRepository;

    public LicensesController(LicensesService licensesService) {
        this.licensesService = licensesService;
    }

    @GetMapping
    public List<Licenses> allLicenses(){
        return licensesService.allLicenses();
    }

    @GetMapping("/new")
    public String newLicenseKey(){
        return new Licenses().newLicenseKey();
    }

    @PostMapping("/{licenseKey}")
    public void registerKey(@PathVariable String licenseKey){
        licensesService.activateLicenseKey(licenseKey);
    }
    @GetMapping("/{licenseKey}")
    public Boolean getRegisteredKeyStatus(@PathVariable String licenseKey){
        return licensesService.findLicenseKeyStatus(licenseKey);
    }
}
