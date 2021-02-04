package com.wild.backend.service;

import com.wild.backend.enitity.Product;
import com.wild.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product newProduct(Product product){
        return productRepository.save(product);
    }
}
