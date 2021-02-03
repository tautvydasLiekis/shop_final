package com.wild.backend.controller;

import com.wild.backend.enitity.Product;
import com.wild.backend.repository.ProductRepository;
import com.wild.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product newProduct(@RequestBody Product product){
        productService.newProduct(product);
        return product;
    }
}
