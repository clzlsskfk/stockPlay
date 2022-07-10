package com.example.hello2.service;

import com.example.hello2.repository.MemoryStockRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StockServiceTest {

    StockService stockService;

    MemoryStockRepository memoryStockRepository;

    @Test
    public void 주식정보_가져오기() throws IOException {

        // 주식수 10개
        int stockNum = 133;

        //given
        String html = "https://finance.naver.com/sise/sise_market_sum.naver?&page=1";
        Connection conn = Jsoup.connect(html);

        Document doc = conn.get();

        Elements stockList = doc.select("table.type_2");


        //when


        //then
        for (Element stockName : stockList.select("tbody")) {

            /** 주식목록의 상위 경로
             * #contentarea > div.box_type_l > table.type_2 > tbody
             */

            // 10의 종목만 가져오기 위하여...
            for (int i = 0; i < stockNum; i++) {
                    /** 주식명 select 경로
                     * #contentarea > div.box_type_l > table.type_2 > tbody > tr:nth-child(2) > td:nth-child(2) > a
                     *
                     */

                    /** 한 개의 종목만 나오게 하는 방법
                     System.out.println(stockName.select("tr:nth-child(2) > td:nth-child(2) > a").text());
                     */

                    /** 동일한 종목 전체 나오게 하는 방법
//                    System.out.println(stockName.select("tr").select("td:nth-child(2) > a").get(i).text());
                     */

                System.out.println(stockName.select("tr").select("td").get(i).text());

                // 자알 가지고 놀았다!! 아래껄로!!!
//
//                for (int j = 2; j < 13; j++) {
//
//                    /** 현재가 select 경로
//                     * #contentarea > div.box_type_l > table.type_2 > tbody > tr:nth-child(2) > td:nth-child(3)
//                     */
//
//                    /** 한 개의 종목만 나오게 하는 방법
//                     System.out.println(stockName.select("tr:nth-child(2) > td:nth-child(3).number").text());
//                     */
//
//                    /** 동일한 종목 전체 나오게 하는 방법
//                     */
//                    System.out.println(stockName.select("td:nth-child(3)").get(j).text());
//
//
//                    /** 코드까지 다 나옴
//                     //            System.out.println(stockName);
//                     */
//
//                }
            }
        }
    }

    @Test
    public void 업비트코인명_가져오기() throws IOException {
        //given
        String html = "https://upbit.com/exchange?code=CRIX.UPBIT.KRW-BTC";
        Connection conn = Jsoup.connect(html);

        Document doc = conn.get();

//        Elements stockList = doc.select("div[id=\"root\"]");

        Element stockList = doc.body();

        //when


        //then

        System.out.println("출력");
        System.out.println(doc.title());

        System.out.println(stockList.select("#UpbitLayout > div:nth-child(4) > div > section.ty02 > article > span.tabB > div > div > div:nth-child(1) > table > tbody > tr.down.on > td.tit > a > strong"));
//      <strong>메인프레임</strong>
//#UpbitLayout > div:nth-child(4) > div > section.ty02 > article > span.tabB
// > div > div > div:nth-child(1) > table > tbody > tr.down.on > td.tit > a > strong

//        for (Element stockName : stockList) {
//            System.out.println("내부출력");
//            System.out.println(stockName.select("section").text());
////            System.out.println(stockName.select("a").text());
//            System.out.println(stockName.select("td"));
//
//        }

    }

    @Test
    public void 만들기위한_Jsoup_사용법() throws IOException {
        //given

        /** 문서의 body 일부분을 가지고 있는 문자열로부터 파싱합니다.
          String html = "<div><p>Lorem ipsum.</p>";
                  Document doc = Jsoup.parseBodyFragment(html);
                  Element body = doc.body();
         */

        /** URL로부터 문서를 파싱하는 방법 입니다. GET 방식의 호출을 합니다.
        Document doc = Jsoup.connect("https://finance.naver.com/sise/sise_market_sum.naver?&page=1").get();
        String title = doc.title();
         */

        /** POST 방식으로 사용할  수도 있습니다.
        Document doc = Jsoup.connect("http://example.com")
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();
         */

        /** 파일로부터 파싱하는 방법 입니다.
        File input = new File("/Users/leenangdo/IdeaProjects/쓰레기폴더/input.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
         */



        //when

        //then
//         System.out.println(doc.text());
    }

}