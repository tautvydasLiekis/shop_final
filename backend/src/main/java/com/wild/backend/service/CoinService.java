package com.wild.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wild.backend.api.btcPrice.CoinApi;
import com.wild.backend.api.btcPrice.CoinData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinService {

    private CoinApi coinApi;
    private ObjectMapper objectMapper;

    public CoinService(CoinApi coinApi, ObjectMapper objectMapper) {
        this.coinApi = coinApi;
        this.objectMapper = objectMapper;
    }

    public List<CoinData> getCoinData() throws JsonProcessingException {

        String json = coinApi.getCoinJson();

        CoinData coinData = objectMapper.readValue(json, CoinData.class);

        List<CoinData> coinDataList = new ArrayList<>();

        coinDataList.add(coinData);

        return coinDataList;
    }
}
