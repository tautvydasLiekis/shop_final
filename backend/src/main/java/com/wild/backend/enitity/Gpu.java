package com.wild.backend.enitity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Gpu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal msrpPrice;

    @Column(nullable = false)
    private Double hashRate;

    @Column(nullable = false)
    private Double powerW;

}
