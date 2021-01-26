package com.wild.backend.api.btcDifficulty;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoinDifficultyApi {

    private RestTemplateBuilder restTemplateBuilder;

    public CoinDifficultyApi(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public String getCoinDifficultyJson(){
        return getClient().getForObject("/v3/block/latest", String.class);
    }

    public RestTemplate getClient(){
        return restTemplateBuilder
                .rootUri("https://chain.api.btc.com")
                .build();
    }

}
