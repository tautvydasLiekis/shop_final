package com.wild.backend.controller;

import com.wild.backend.enitity.Licenses;
import com.wild.backend.service.LicensesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicensesController {

    private LicensesService licensesService;

    public LicensesController(LicensesService licensesService) {
        this.licensesService = licensesService;
    }

    @GetMapping
    public List<Licenses> allLicenses(){
        return licensesService.allLicenses();
    }
}
