package com.wild.backend.enitity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
public class ProductKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Type(type = "uuid-char")
//    @Column(name="licence_key", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private String licence_key;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    public Long getId() {
        return id;
    }

    public String getLicence_key() {
        return licence_key;
    }

    @JsonBackReference
    public Product getProduct() {
        return product;
    }
}
