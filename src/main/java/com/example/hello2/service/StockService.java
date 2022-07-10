package com.example.hello2.service;

import com.example.hello2.repository.MemoryStockRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StockService {

    private final MemoryStockRepository memoryStockRepository;

    @Autowired
    public StockService(MemoryStockRepository memoryStockRepository) {
        this.memoryStockRepository = memoryStockRepository;
    }

    public String getName() {

//        memoryStockRepository.parseName();

        return "이름 반환";
    }

}
