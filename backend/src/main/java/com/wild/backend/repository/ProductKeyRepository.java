package com.wild.backend.repository;

import com.wild.backend.enitity.ProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductKeyRepository extends JpaRepository<ProductKey, Long> {
}
