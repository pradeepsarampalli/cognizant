package com.cognizant.ormlearn.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public List<Stock> getStockForMonth(String code, LocalDate start, LocalDate end) {
        return stockRepository.findByCodeAndDateBetween(code, start, end);
    }

    @Transactional
    public List<Stock> getStockAboveClose(String code, BigDecimal close) {
        return stockRepository.findByCodeAndCloseGreaterThan(code, close);
    }

    @Transactional
    public List<Stock> getTop3HighestVolume() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional
    public List<Stock> getTop3LowestClose(String code) {
        return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
    }
}
