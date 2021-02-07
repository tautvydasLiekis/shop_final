package com.wild.backend.repository;

import com.wild.backend.enitity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Properties;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(long id);

    Product findProductByName(String name);
}
