package com.cognizant.productservice.controller;

import com.cognizant.productservice.model.Product;
import com.cognizant.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Pulled from config-server (product-service.properties), demonstrating
    // centralized configuration.
    @Value("${inventory.low-stock-threshold:10}")
    private int lowStockThreshold;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/low-stock")
    public ResponseEntity<Boolean> isLowStock(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(p -> ResponseEntity.ok(p.getStock() < lowStockThreshold))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
