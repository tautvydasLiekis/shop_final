package com.wild.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wild.backend.api.btcDifficulty.CoinDifficulty;
import com.wild.backend.api.btcDifficulty.CoinDifficultyApi;
import com.wild.backend.api.btcPrice.CoinApi;
import com.wild.backend.api.btcPrice.CoinData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CoinService {

    private CoinApi coinApi;
    private CoinDifficultyApi coinDifficultyApi;
    private ObjectMapper objectMapper;

    public CoinService(CoinApi coinApi, CoinDifficultyApi coinDifficultyApi, ObjectMapper objectMapper) {
        this.coinApi = coinApi;
        this.coinDifficultyApi = coinDifficultyApi;
        this.objectMapper = objectMapper;
    }

    public BigDecimal getCoinData() throws JsonProcessingException {

        String json = coinApi.getCoinJson();

        CoinData coinData = objectMapper.readValue(json, CoinData.class);

        coinData.setLast(coinData.getLast());

        return coinData.getLast();
    }

    public CoinDifficulty getCoinDifficulty() throws JsonProcessingException{

        CoinDifficulty coinDifficulty=new CoinDifficulty();

        String json = coinDifficultyApi.getCoinDifficultyJson();

        ObjectNode root = objectMapper.readValue(json, ObjectNode.class);

        var data = root.get("data");

        coinDifficulty.setDifficulty_double(data.get("difficulty_double").asDouble());

        coinDifficulty.setReward_block(data.get("reward_block").asDouble());

        return coinDifficulty;
    }

    public Double getBlockReward() throws JsonProcessingException{

        CoinDifficulty coinDifficulty=new CoinDifficulty();

        String json = coinDifficultyApi.getCoinDifficultyJson();

        ObjectNode root = objectMapper.readValue(json, ObjectNode.class);

        var data = root.get("data");

        coinDifficulty.setReward_block(data.get("reward_block").asDouble());

        return coinDifficulty.getDifficulty_double();
    }
}
