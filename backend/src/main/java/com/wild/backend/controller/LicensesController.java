package com.wild.backend.controller;

import com.wild.backend.enitity.Licenses;
import com.wild.backend.repository.LicensesRepository;
import com.wild.backend.service.LicensesService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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

    @PatchMapping("/{licenseKey}")
    public Boolean registerKey(@PathVariable("licenseKey") Integer licenseKey) {
        return licensesService.activateLicenseKey(licenseKey);
    }

    @GetMapping("/{licenseKey}")
    public Boolean getRegisteredKeyStatus(@PathVariable("licenseKey") Integer licenseKey) {
        return licensesService.findLicenseKeyStatus(licenseKey);
    }

    @GetMapping("/{username}")
    public List<Licenses> getUsersLicenses(@PathVariable("username") Authentication authentication){
        return licensesService.licensesByUsername(authentication.getName());
    }
}
