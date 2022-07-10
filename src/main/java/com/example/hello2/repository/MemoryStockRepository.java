package com.example.hello2.repository;

import com.example.hello2.domain.StockInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryStockRepository implements StockInfoRepository{

    private static Map<String, StockInfo> stockRepo = new HashMap<>();

    @Override
    public StockInfo parseName(StockInfo stockInfo) {
        String html = "www.naver.com";

        Document doc = Jsoup.parse(html);

        stockRepo.put(stockInfo.getName(), stockInfo);

        return stockInfo;

    }

}
