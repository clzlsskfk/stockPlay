package com.example.hello2.repository;

import com.example.hello2.domain.StockInfo;

import java.io.IOException;
import java.util.List;

public interface StockInfoRepository {
    StockInfo saveStockData(StockInfo stockInfo) throws IOException;

    List<StockInfo> findAll();

}
