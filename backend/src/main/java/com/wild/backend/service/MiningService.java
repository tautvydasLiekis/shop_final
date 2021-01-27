package com.wild.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MiningService {

    private CoinService coinService;

    public MiningService(CoinService coinService) {
        this.coinService = coinService;
    }

    public BigDecimal random() throws JsonProcessingException {
        return coinService.getCoinData();
    }

}
