package com.wild.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wild.backend.api.coins.Coin;
import com.wild.backend.api.coins.CoinApi;
import com.wild.backend.api.coins.CoinData;
import org.springframework.stereotype.Service;

@Service
public class CoinService {

    private CoinApi coinApi;
    private ObjectMapper objectMapper;

    public CoinService(CoinApi coinApi, ObjectMapper objectMapper) {
        this.coinApi = coinApi;
        this.objectMapper = objectMapper;
    }

    public Coin getCoinData() {
        Coin coin = new Coin();

        String json = coinApi.getCoinJson();

        ObjectNode root;
        try {
            root = objectMapper.readValue(json, ObjectNode.class);

            CoinData coinData = objectMapper.readValue(root.get("main").toString(), CoinData.class);
            coin.setCoins(coinData);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return coin;
    }
}
