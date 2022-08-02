package com.example.hello2.repository;

import com.example.hello2.domain.StockInfo;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryStockRepository implements StockInfoRepository{

    private static Map<String, StockInfo> stockRepo = new HashMap<>();

    @Override
    public StockInfo saveStockData(StockInfo stockInfo) throws IOException {

        stockRepo.put(stockInfo.getNo(), stockInfo);
        stockRepo.put(stockInfo.getNo(), stockInfo);
        stockRepo.put(stockInfo.getNo(), stockInfo);
        stockRepo.put(stockInfo.getNo(), stockInfo);

        return stockInfo;
    }


    @Override
    public List<StockInfo> findAll() {
        return new ArrayList<>(stockRepo.values());
    }


}
