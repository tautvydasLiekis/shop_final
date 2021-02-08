package com.wild.backend.controller;

import com.wild.backend.enitity.Product;
import com.wild.backend.enitity.dto.ProductDTO;
import com.wild.backend.repository.ProductRepository;
import com.wild.backend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> newProduct(@RequestBody @Valid Product product){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.newProduct(product));
    }
}
