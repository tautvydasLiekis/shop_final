package com.wild.backend.api.coins;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {
//    private List<CoinData> coins= new ArrayList<>();
    private CoinData coins;
}
