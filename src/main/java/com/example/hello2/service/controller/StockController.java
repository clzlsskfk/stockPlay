package com.example.hello2.service.controller;

import com.example.hello2.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {

    @Autowired
    private StockService stockService;

//    @GetMapping("/StockList")
//    public string getName() {
//
//
//
//        return
//    }
}
