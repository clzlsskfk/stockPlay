package com.example.hello2.domain;

/**
 * 코인의 전반적인 정보를 저장하는 Entity
 *
 * 종목명	검색비율	현재가	전일비	등락률	거래량	시가	고가	저가	PER	ROE
 */


public class StockInfo {
    //    private String 코인정보

    private String no;  //순위
    private String stockName;   //종목명
    private String stockPresentPrice;   //현재가
    private String stockQuant;  //거래량
    private String stockMarketSum;  //시가총액(억)
    private String stockOperatingProfit;    //영업이익
    private String stockPer;    //PER
    private String stockNetIncome;  //당기순이익
    private String stockRoe;    //ROE
    private String stockRate;   //등락률

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockPresentPrice() {
        return stockPresentPrice;
    }

    public void setStockPresentPrice(String stockPresentPrice) {
        this.stockPresentPrice = stockPresentPrice;
    }

    public String getStockQuant() {
        return stockQuant;
    }

    public void setStockQuant(String stockQuant) {
        this.stockQuant = stockQuant;
    }

    public String getStockMarketSum() {
        return stockMarketSum;
    }

    public void setStockMarketSum(String stockMarketSum) {
        this.stockMarketSum = stockMarketSum;
    }

    public String getStockOperatingProfit() {
        return stockOperatingProfit;
    }

    public void setStockOperatingProfit(String stockOperatingProfit) {
        this.stockOperatingProfit = stockOperatingProfit;
    }

    public String getStockPer() {
        return stockPer;
    }

    public void setStockPer(String stockPer) {
        this.stockPer = stockPer;
    }

    public String getStockNetIncome() {
        return stockNetIncome;
    }

    public void setStockNetIncome(String stockNetIncome) {
        this.stockNetIncome = stockNetIncome;
    }

    public String getStockRoe() {
        return stockRoe;
    }

    public void setStockRoe(String stockRoe) {
        this.stockRoe = stockRoe;
    }

    public String getStockRate() {
        return stockRate;
    }

    public void setStockRate(String stockRate) {
        this.stockRate = stockRate;
    }
}
