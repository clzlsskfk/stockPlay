package com.example.hello2.domain;

/**
 * 코인의 전반적인 정보를 저장하는 Entity
 *
 * 이름, 코드, 현재가, 전일시세, 거래량
 */


public class StockInfo {
//    private String 코인정보
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
