package com.wild.backend.enitity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
public class ProductKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @Column(name="licence_key", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private String licence_key;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
}
