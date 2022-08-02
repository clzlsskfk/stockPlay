package com.example.hello2.repository;

import com.example.hello2.domain.StockInfo;
import com.example.hello2.service.StockService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class MemoryStockRepositoryTest {

    @Autowired
    StockService stockService;

    @Autowired
    MemoryStockRepository memoryStockRepository;



    @Test
    public void 주식정보_가져오기() throws IOException {

        StockInfo stock = new StockInfo();

        //given
//        List<String> sList = new ArrayList<>();

        // 주식수 10개
        int stockListNum = 14;
        String html = "https://finance.naver.com/sise/sise_market_sum.naver?&page=1";
        Connection conn = Jsoup.connect(html);

        Document doc = conn.get();

        Elements stockLists = doc.select("table.type_2");

        //when

        for (Element stockList : stockLists.select("tbody")) {
                /** 주식목록의 상위 경로
                 * #contentarea > div.box_type_l > table.type_2 > tbody
                 */
            for (int i = 1; i < stockListNum; i++) {

                    Element sList = stockList.select("tr").get(i);

//#contentarea > div.box_type_l > table > tbody > tr:nth-child(8) > td
//                    <td colspan="12" class="blank_06"></td>

                if(sList.hasText()) {
                    stock.setNo(sList.select("td").get(0).text());
                    stock.setStockName(sList.select("td").get(1).text());
                    stock.setStockPresentPrice(sList.select("td").get(3).text());
                    stock.setStockQuant(sList.select("td").get(10).text());

                    System.out.println(stock.getNo());
                    System.out.println(stock.getStockName());
                    System.out.println(stock.getStockPresentPrice());
                    System.out.println(stock.getStockQuant());

                    System.out.println("stock에 뭐가 들어가있는가." + stock.getStockName());
                    memoryStockRepository.saveStockData(stock);
                }


                // 10의 종목만 가져오기 위하여...
                //            for (int i = 1; i < 13; i++) {
                //                /** 주식명 select 경로
                //                 * #contentarea > div.box_type_l > table.type_2 > tbody > tr:nth-child(2) > td:nth-child(2) > a
                //                 *
                //                 */
                //
                //                /** 한 개의 종목만 나오게 하는 방법
                //                 System.out.println(stockName.select("tr:nth-child(2) > td:nth-child(2) > a").text());
    //                 */
    //
    //                /** 동일한 종목 전체 나오게 하는 방법
    //                System.out.println(stockName.select("tr").select("td:nth-child(2) > a").get(i).text());
    //                 */
    //
    //
    ////                sList.add(stockName.select("tr").select("td").get(i).text());
    ////                for(String tr : sList) {
    ////                    System.out.println(tr);
    ////
    ////                }
    //
    //
    ////
    ////                stock.setStockName(tr);
    ////                System.out.println(tr);
    ////                for (int j = 1; j < 13; j++) {
    ////                }
    //
    //
    //
    //
    //                // 자알 가지고 놀았다!! 아래껄로!!!
    ////
    ////                for (int j = 2; j < 13; j++) {
    ////
    ////                    /** 현재가 select 경로
    ////                     * #contentarea > div.box_type_l > table.type_2 > tbody > tr:nth-child(2) > td:nth-child(3)
    ////                     */
    ////
    ////                    /** 한 개의 종목만 나오게 하는 방법
    ////                     System.out.println(stockName.select("tr:nth-child(2) > td:nth-child(3).number").text());
    ////                     */
    ////
    ////                    /** 동일한 종목 전체 나오게 하는 방법
    ////                     */
    ////                    System.out.println(stockName.select("td:nth-child(3)").get(j).text());
    ////
    ////
    ////                    /** 코드까지 다 나옴
    ////                     //            System.out.println(stockName);
    ////                     */
    ////
                ////                }

                //            }
            }
        }



        //then

    }

    @Test
    public void test() throws IOException {

        int stockNum = 133;

        String html = "https://finance.naver.com/sise/sise_market_sum.naver?&page=1";
        Connection conn = Jsoup.connect(html);

        Document doc = conn.get();

        /** doc에 무엇이 들어있는지 확인
         */
        System.out.println(doc);

        /** doc에 설정한 select에 무엇이 들어있는지 확인
         System.out.println(doc.select("table.type_2").text());
         */

        Elements stockLists = doc.select("table.type_2");

        /** Elements에 무엇이 들어있는지 확인
         System.out.println(stockLists);
         */

        /** Element 는 하나의 정보만 가지고 오는 것이기 때문에 사용 안된다.
         Element stockList = doc.select("table.type_2").get(0);
         System.out.println(stockList);
         */


        for (Element stockName : stockLists.select("tbody")) {

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

//                    System.out.println(stockName.select("tr").select("td").get(i).text());

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