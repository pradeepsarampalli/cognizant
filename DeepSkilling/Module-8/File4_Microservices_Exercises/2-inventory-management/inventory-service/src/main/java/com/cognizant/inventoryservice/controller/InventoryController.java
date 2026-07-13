package com.cognizant.inventoryservice.controller;

import com.cognizant.inventoryservice.client.ProductServiceClient;
import com.cognizant.inventoryservice.model.StockLevel;
import com.cognizant.inventoryservice.repository.StockLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private StockLevelRepository stockLevelRepository;

    @Autowired
    private ProductServiceClient productServiceClient;

    // From config-server (inventory-service.properties)
    @Value("${inventory.restock-batch-size:50}")
    private int restockBatchSize;

    @PostMapping
    public ResponseEntity<StockLevel> createStockLevel(@RequestBody StockLevel stockLevel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stockLevelRepository.save(stockLevel));
    }

    @GetMapping
    public List<StockLevel> getAll() {
        return stockLevelRepository.findAll();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Map<String, Object>> getStockForProduct(@PathVariable Long productId) {
        return stockLevelRepository.findByProductId(productId)
                .map(stock -> ResponseEntity.ok(Map.<String, Object>of(
                        "stock", stock,
                        "product", productServiceClient.getProduct(productId),
                        "suggestedRestockQty", restockBatchSize
                )))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/product/{productId}/adjust")
    public ResponseEntity<StockLevel> adjustStock(@PathVariable Long productId, @RequestParam int delta) {
        return stockLevelRepository.findByProductId(productId)
                .map(stock -> {
                    stock.setQuantityAvailable(stock.getQuantityAvailable() + delta);
                    return ResponseEntity.ok(stockLevelRepository.save(stock));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
