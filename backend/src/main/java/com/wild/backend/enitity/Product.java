package com.wild.backend.enitity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "is_active")
    private Boolean flag;

    @OneToMany(mappedBy = "product")
    private Set<ProductKey> productKeys;

}

