package com.example.hello2.controller;

import com.example.hello2.domain.StockInfo;
import com.example.hello2.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/")
    public String stockList(Model model) throws IOException {

        stockService.stockSave();

        List<StockInfo> stockMembers = stockService.findStockLists();
        model.addAttribute("stockList", stockMembers);

        return "stocks/StockList";
    }
}
