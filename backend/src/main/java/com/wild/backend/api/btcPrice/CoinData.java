package com.wild.backend.api.btcPrice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinData {

    @JsonProperty("last")
    private BigDecimal last;

    @JsonProperty("volume")
    private Float volume;
}
