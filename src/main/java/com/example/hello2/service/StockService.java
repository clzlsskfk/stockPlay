package com.example.hello2.service;

import com.example.hello2.domain.StockInfo;
import com.example.hello2.repository.StockInfoRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StockService {
    private final StockInfoRepository stockInfoRepository;
    private Document doc;

    @Autowired
    public StockService(StockInfoRepository stockInfoRepository) {
        this.stockInfoRepository = stockInfoRepository;
    }


    public String stockSave() throws IOException {

        StockInfo stockInfo = new StockInfo();

        stockDataPaser();

        return stockInfo.getStockName();
    }


    public List<StockInfo> findStockLists() {
        return stockInfoRepository.findAll();
    }

    private void stockDataPaser() throws IOException {

        String[] listChoises = {"quant", "net_income", "market_sum", "operating_profit", "per", "roe"};
        int stockListNum = 14;
//        필드값 넣어 검색
//        https://finance.naver.com/sise/field_submit.nhn?menu=market_sum&returnUrl=http%3A%2F%2Ffinance.naver.com%2Fsise%2Fsise_market_sum.nhn&fieldIds=market_sum&fieldIds=property_total&fieldIds=debt_total&fieldIds=sales&fieldIds=eps&fieldIds=pbr
//        https://finance.naver.com/sise/field_submit.nhn?menu=market_sum&returnUrl=http%3A%2F%2Ffinance.naver.com%2Fsise%2Fsise_market_sum.nhn&fieldIds=market_sum&fieldIds=property_total&fieldIds=debt_total&fieldIds=sales&fieldIds=eps&fieldIds=pbr

        //접근 할 URL
//        String html = "https://finance.naver.com/sise/sise_market_sum.naver?&page=1";

        // 항목 체크 요청 URL(POST)
        String resHtml = "https://finance.naver.com/sise/field_submit.nhn?menu=market_sum&returnUrl=http%3A%2F%2Ffinance.naver.com%2Fsise%2Fsise_market_sum.nhn&fieldIds=" + listChoises[0] + "&fieldIds=" + listChoises[1] +  "&fieldIds=" + listChoises[2] + "&fieldIds=" + listChoises[3] + "&fieldIds=" + listChoises[4] + "&fieldIds=" + listChoises[5];

        //네이버에 내가 원하는 항목 요청
        Connection conn = Jsoup.connect(resHtml);
        Document doc = conn.post();

        // 홈페이지 접근
        doc = conn.get();

        Elements stockLists = doc.select("#contentarea > div.box_type_l > table.type_2");

        Elements selects = doc.select("form[name=field_form]");

//        for (Element select : selects) {
//            System.out.println(select.select("input[checked]"));
//        }

        for (Element stockList : stockLists.select("tbody")) {
            /** 주식목록이 포함된 상위 경로
             * #contentarea > div.box_type_l > table.type_2 > tbody
             */

            for (int i = 1; i < stockListNum+1; i++) {

                StockInfo stockInfo = new StockInfo();
                // 주식목록만의 정보

//                System.out.println(stockList.select("tr"));

//                #contentarea > div.box_type_l > table.type_2 > tbody > tr:nth-child(2) > td:nth-child(2)

                Element sList = stockList.select("tr").get(i);

                // 한 종목에 대한 정보
                if(sList.hasText()) {
//                    순위	종목명	현재가	등락률	거래량	시가총액	영업이익	당기순이익	PER	ROE
                    stockInfo.setNo(sList.select("td").get(0).text());
                    stockInfo.setStockName(sList.select("td").get(1).text());
                    stockInfo.setStockPresentPrice(sList.select("td").get(2).text());
                    stockInfo.setStockRate(sList.select("td").get(4).text());
                    stockInfo.setStockQuant(sList.select("td").get(6).text());
                    stockInfo.setStockMarketSum(sList.select("td").get(7).text());
                    stockInfo.setStockOperatingProfit(sList.select("td").get(8).text());
                    stockInfo.setStockNetIncome(sList.select("td").get(9).text());
                    stockInfo.setStockPer(sList.select("td").get(10).text());
                    stockInfo.setStockRoe(sList.select("td").get(11).text());
                }
                    stockInfoRepository.saveStockData(stockInfo);
            }
        }
    }

}
