package com.example.hello2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "책의 내용을 이해하기 위하여 만들 작업";
    }

    @GetMapping("/list")
    public String coinList(Model model) {
        model.addAttribute("data", "Coin");
        return "StockList";
    }

}