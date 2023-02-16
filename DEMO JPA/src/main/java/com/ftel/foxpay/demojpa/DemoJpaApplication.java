package com.ftel.foxpay.demojpa;
import com.ftel.foxpay.demojpa.model.LuckyNumber;
import com.ftel.foxpay.demojpa.service.LuckyNumberService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {
    @Autowired
    LuckyNumberService luckyNumberService;
    public static void main(String[] args) {

        SpringApplication.run(DemoJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Document doc = Jsoup.connect("https://xosoketqua.com/xsmb-xo-so-mien-bac.html").get();
        String title = doc.title();
        System.out.println("Website's name " + title);
        /*
        Elements mainContents = doc.getElementsByClass("block-main-content");
        for (Element mainContent: mainContents) {
            System.out.println("=================================");
            Elements trs = mainContent.getElementsByTag("tr");
            for (Element tr: trs) {
                Elements tds = tr.getElementsByTag("td");
                if (tds.stream().count() == 2) {
                    Element prize = tds.first();
                    if (prize.text().contains("G")) {
                        System.out.println("----" + prize.text() + "----");
                        Elements spans = tds.last().getElementsByTag("span");
                        for (Element span: spans ) {
                            System.out.print(span.text() + " ");
                        }
                        System.out.println("");
                    }
                }
            }
        }
        */

        //ln.setId();
        Elements resultBlocks = doc.select("div.block");
        for (Element block: resultBlocks) {
//            System.out.println("=============================================");
            Element link = block.select("div.list-link > h2 > a").last();
            Elements trs = block.select("div.block-main-content > table.table-xsmb > tbody > tr");
            if (link != null) {
                LuckyNumber ln = new LuckyNumber();
                ln.setDateOfPrize(link.text());
//                System.out.println(link.text());
//                System.out.println("=============================================");
                for (Element tr: trs) {
                    Elements tds = tr.getElementsByTag("td");
                    if (tds.stream().count() == 2) {
                        Element prize = tds.first();
                        if (prize.text().contains("G")) {
//                            System.out.print(prize.text() + ": ");
                            Elements spans = tds.last().getElementsByTag("span");
                            String prizeTitle = "";
                            for (Element span: spans ) {
                                prizeTitle = prizeTitle.concat(" " + span.text());
                            }
//                            System.out.println(prize.text());
                            System.out.println(prizeTitle);
                            switch (prize.text()) {
                                case "G.ĐB" :
                                    ln.setSpecialPrize(prizeTitle);
                                    break;
                                case "G.1":
                                    ln.setFirstPrize(prizeTitle);
                                    break;
                                case "G.2":
                                    ln.setSecondPrize(prizeTitle);
                                    break;
                                case "G.3":
                                    ln.setThirdPrize(prizeTitle);
                                    break;
                                case "G.4":
                                    ln.setFourthPrize(prizeTitle);
                                    break;
                                case "G.5":
                                    ln.setFifthPrize(prizeTitle);
                                    break;
                                case "G.6":
                                    ln.setSixthPrize(prizeTitle);
                                    break;
                                case "G.7":
                                    ln.setSeventhPrize(prizeTitle);
                                    break;
                            }
//                            System.out.println("");
                        }
                    }
                }

                luckyNumberService.addLuckyNumber(ln);
            }
        }
    }

    private void crawlData() {

    }
}
