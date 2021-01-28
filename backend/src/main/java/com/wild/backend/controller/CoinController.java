package com.wild.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wild.backend.api.btcDifficulty.CoinDifficulty;
import com.wild.backend.service.CoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/coin")
public class CoinController {

    private CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/data")
    public BigDecimal getCoinData() throws JsonProcessingException {
        return coinService.getCoinData();
    }

    @GetMapping("/data1")
    public CoinDifficulty getCoinDifficulty() throws JsonProcessingException {
        return coinService.getCoinDifficulty();
    }
}
