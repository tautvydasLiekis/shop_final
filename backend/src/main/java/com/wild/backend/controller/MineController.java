package com.wild.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wild.backend.service.MiningService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mining")
public class MineController {

    MiningService miningService;

    public MineController(MiningService miningService) {
        this.miningService = miningService;
    }

    @GetMapping("/data")
    public String getRandom() throws JsonProcessingException {
        return "<h1>"+miningService.random()+"</h1>";
    }

}
