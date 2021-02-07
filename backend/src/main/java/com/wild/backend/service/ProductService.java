package com.wild.backend.service;

import com.wild.backend.enitity.Product;
import com.wild.backend.enitity.dto.ProductDTO;
import com.wild.backend.repository.LicensesRepository;
import com.wild.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private LicensesRepository licensesRepository;

    public ProductService(ProductRepository productRepository, LicensesRepository licensesRepository) {
        this.productRepository = productRepository;
        this.licensesRepository = licensesRepository;
    }

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll()
                .stream().map(e -> new ProductDTO(e))
                .collect(Collectors.toList());
    }

    public Product newProduct(Product product){
        product.setFlag(true);
        return productRepository.save(product);
    }

    public Product getById(long id){
        return productRepository.findProductById(id);
    }
}
