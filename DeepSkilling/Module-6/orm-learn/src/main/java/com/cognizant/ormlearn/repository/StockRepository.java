package com.cognizant.ormlearn.repository;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Get all stock details of Facebook in the month of September 2019
    List<Stock> findByCodeAndDateBetween(String code, LocalDate startDate, LocalDate endDate);

    // Get all google stock details where the closing price was greater than a value
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal close);

    // Find the top 3 dates (across all stocks) which had the highest volume of transactions
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Identify the three dates when a given stock's closing price was the lowest
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
