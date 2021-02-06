package com.wild.backend.enitity.dto;

import com.wild.backend.enitity.Product;
import com.wild.backend.enitity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean flag;
    private List<String> users;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.flag = product.getFlag();
        this.users = product.getUsers().stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
    }
}
