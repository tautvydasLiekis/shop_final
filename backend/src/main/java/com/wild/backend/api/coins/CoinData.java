package com.wild.backend.api.coins;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinData {
    private String id;
    private String name;
    private String symbol;
    private Double price;
}
