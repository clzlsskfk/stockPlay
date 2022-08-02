package com.example.hello2;

import com.example.hello2.repository.MemoryStockRepository;
import com.example.hello2.repository.StockInfoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class stockConfig {

    @Bean
    public StockInfoRepository stockInfoRepository() {
        return new MemoryStockRepository();
    }
}