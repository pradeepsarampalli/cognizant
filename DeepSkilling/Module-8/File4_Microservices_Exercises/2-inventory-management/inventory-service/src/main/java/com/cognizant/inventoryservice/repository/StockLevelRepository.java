package com.cognizant.inventoryservice.repository;

import com.cognizant.inventoryservice.model.StockLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockLevelRepository extends JpaRepository<StockLevel, Long> {
    Optional<StockLevel> findByProductId(Long productId);
}
