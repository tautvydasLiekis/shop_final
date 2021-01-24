package com.wild.backend.api.coins;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoinApi {

    private RestTemplateBuilder restTemplateBuilder;

    public CoinApi(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public String getCoinJson(){
        return getClient().getForObject("/coins?skip=0&limit=1&currency=EUR", String.class);
    }

    public RestTemplate getClient(){
        return restTemplateBuilder
                .rootUri("https://api.coinstats.app/public/v1")
                .build();
    }

}

