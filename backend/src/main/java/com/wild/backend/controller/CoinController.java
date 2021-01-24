package com.wild.backend.controller;

import com.wild.backend.api.coins.Coin;
import com.wild.backend.service.CoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coin")
public class CoinController {

    private CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/data")
    public Coin getCoinData(){
        return coinService.getCoinData();
    }
}
