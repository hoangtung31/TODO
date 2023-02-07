package com.ftel.foxpay.demojpa;

import com.ftel.foxpay.demojpa.model.WebCrawler;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=================================");
//        WebCrawler crawler = new WebCrawler();
//        String rootURL = "https://www.coingecko.com/en/all-cryptocurrencies";
//        crawler.crawl(rootURL, 1000);
        Document doc = Jsoup.connect("https://xosoketqua.com").get();
        String title = doc.title();
        System.out.println("Website's name " + title);
        System.out.println("=================================");
        Element content = doc.getElementById("kqngay_07022023");
        Elements hori = content.getElementsByClass("div-horizontal");
        for (Element hor: hori) {
//            if(hori.attr("class").equals("special-prize-lg")) {
            System.out.println("=================================");
                System.out.println(hori.text());
//            }
        }
        System.out.println(hori);
//        Elements trs = content.getElementsByTag("tr");
//        for (Element tr : trs) {
//            System.out.println(tr);
//        }
//        Document doc = Jsoup.connect("https://www.coingecko.com/en/all-cryptocurrencies")
//                .data("store_type","3", "sort" , "distance")
//                .userAgent("Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.121 Safari/535.2")
//                .method(Connection.Method.POST)
//                .timeout(0).ignoreHttpErrors(true)
//                .get();
//        String title = doc.title();
//        System.out.println("Website's name " + title);
    }
}
