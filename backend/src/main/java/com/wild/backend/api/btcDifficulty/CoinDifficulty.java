package com.wild.backend.api.btcDifficulty;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinDifficulty {

    private Double difficulty_double;

}
