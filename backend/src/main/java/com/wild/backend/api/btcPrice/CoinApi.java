package com.wild.backend.api.btcPrice;

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
        return getClient().getForObject("/API/Public/btceur/ticker.json", String.class);
    }

    public RestTemplate getClient(){
        return restTemplateBuilder
                .rootUri("https://bitbay.net")
                .build();
    }

}

