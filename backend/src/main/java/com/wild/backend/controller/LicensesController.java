package com.wild.backend.controller;

import com.wild.backend.enitity.Licenses;
import com.wild.backend.service.LicensesService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicensesController {

    private LicensesService licensesService;

    public LicensesController(LicensesService licensesService) {
        this.licensesService = licensesService;
    }

    @GetMapping("/all")
    public List<Licenses> allLicenses() {
        return licensesService.allLicenses();
    }

    @PatchMapping
    public Boolean registerKey(@RequestParam("licenseKey") Integer licenseKey) {
        return licensesService.activateLicenseKey(licenseKey);
    }

    @GetMapping
    public Boolean getRegisteredKeyStatus(@RequestParam("licenseKey") Integer licenseKey) {
        return licensesService.findLicenseKeyStatus(licenseKey);
    }

    @GetMapping("/user")
    public List<Licenses> getUsersLicenses(@RequestParam("username") Authentication authentication){
        return licensesService.licensesByUsername(authentication.getName());
    }
}
