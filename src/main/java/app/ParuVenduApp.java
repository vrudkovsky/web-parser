package app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParuVenduApp {

    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36";

    public static void main(String[] args) throws IOException {
        Document doc1 = Jsoup.connect("https://www.paruvendu.fr/immobilier/annonceimmofo/liste/listeAnnonces?tt=1&tbApp=1&tbDup=1&tbChb=1&tbLof=1&tbAtl=1&tbPla=1&tbMai=1&tbVil=1&tbCha=1&tbPro=1&tbHot=1&tbMou=1&tbFer=1&at=1&nbp0=99&pa=FR&lol=0&ray=50&codeINSEE=79191").userAgent(USER_AGENT).get();

        Document doc2 = Jsoup.connect("https://www.paruvendu.fr/immobilier/annonceimmofo/liste/listeAnnonces?tt=1&tbApp=1&tbDup=1&tbChb=1&tbLof=1&tbAtl=1&tbPla=1&tbMai=1&tbVil=1&tbCha=1&tbPro=1&tbHot=1&tbMou=1&tbFer=1&at=1&nbp0=99&pa=FR&lol=0&ray=50&codeINSEE=79191&p=2").userAgent(USER_AGENT).get();

        Document doc3 = Jsoup.connect("https://www.paruvendu.fr/immobilier/annonceimmofo/liste/listeAnnonces?tt=1&tbApp=1&tbDup=1&tbChb=1&tbLof=1&tbAtl=1&tbPla=1&tbMai=1&tbVil=1&tbCha=1&tbPro=1&tbHot=1&tbMou=1&tbFer=1&at=1&nbp0=99&pa=FR&lol=0&ray=50&codeINSEE=79191&p=3").userAgent(USER_AGENT).get();

        Document doc4 = Jsoup.connect("https://www.paruvendu.fr/immobilier/annonceimmofo/liste/listeAnnonces?tt=1&tbApp=1&tbDup=1&tbChb=1&tbLof=1&tbAtl=1&tbPla=1&tbMai=1&tbVil=1&tbCha=1&tbPro=1&tbHot=1&tbMou=1&tbFer=1&at=1&nbp0=99&pa=FR&lol=0&ray=50&codeINSEE=79191&p=4").userAgent(USER_AGENT).get();

        Document doc5 = Jsoup.connect("https://www.paruvendu.fr/immobilier/annonceimmofo/liste/listeAnnonces?tt=1&tbApp=1&tbDup=1&tbChb=1&tbLof=1&tbAtl=1&tbPla=1&tbMai=1&tbVil=1&tbCha=1&tbPro=1&tbHot=1&tbMou=1&tbFer=1&at=1&nbp0=99&pa=FR&lol=0&ray=50&codeINSEE=79191&p=5").userAgent(USER_AGENT).get();




        log(doc1.title());
        log(doc2.title());
        log(doc3.title());
        log(doc4.title());
        log(doc5.title());

        //page #1
        Elements divs1 = doc1.select("div.ergov3-txtannonce > h3 > span");
        Elements cites1 = doc1.select("div.ergov3-txtannonce > h3 > cite");
        Elements descs1 = doc1.select("div.ergov3-txtannonce > p:first-of-type");
        Elements prices1 = doc1.select("div.ergov3-priceannonce");

        //page #2
        Elements divs2 = doc2.select("div.ergov3-txtannonce > h3 > span");
        Elements cites2 = doc2.select("div.ergov3-txtannonce > h3 > cite");
        Elements descs2 = doc2.select("div.ergov3-txtannonce > p:first-of-type");
        Elements prices2 = doc2.select("div.ergov3-priceannonce");

        //page #3
        Elements divs3 = doc3.select("div.ergov3-txtannonce > h3 > span");
        Elements cites3 = doc3.select("div.ergov3-txtannonce > h3 > cite");
        Elements descs3 = doc3.select("div.ergov3-txtannonce > p:first-of-type");
        Elements prices3 = doc3.select("div.ergov3-priceannonce");

        //page #4
        Elements divs4 = doc4.select("div.ergov3-txtannonce > h3 > span");
        Elements cites4 = doc4.select("div.ergov3-txtannonce > h3 > cite");
        Elements descs4 = doc4.select("div.ergov3-txtannonce > p:first-of-type");
        Elements prices4 = doc4.select("div.ergov3-priceannonce");

        //page #5
        Elements divs5 = doc5.select("div.ergov3-txtannonce > h3 > span");
        Elements cites5 = doc5.select("div.ergov3-txtannonce > h3 > cite");
        Elements descs5 = doc5.select("div.ergov3-txtannonce > p:first-of-type");
        Elements prices5 = doc5.select("div.ergov3-priceannonce");


        //Titles
        for (Element el : divs1) {
            log("Title: %s", el.text());
        }

        System.out.println("============");
        //Cites
        for (Element el : cites1) {
            log("Cites: %s", el.text());
        }

        System.out.println("============");
        //Prices
        for (Element el : prices1) {
            log("Price: %s", el.text());
        }

        System.out.println("============");
        //Description
        for (Element el : descs1) {
            log("Desc: %s", el.text());
        }



        System.out.println("================");
        System.out.println("==== Page 2 ====");
        System.out.println("================");

        //Titles
        for (Element el : divs2) {
            log("Title: %s", el.text());
        }

        System.out.println("============");
        //Cites
        for (Element el : cites2) {
            log("Cites: %s", el.text());
        }

        System.out.println("============");
        //Prices
        for (Element el : prices2) {
            log("Price: %s", el.text());
        }

        System.out.println("============");
        //Description
        for (Element el : descs2) {
            log("Desc: %s", el.text());
        }

        System.out.println("================");
        System.out.println("==== Page 3 ====");
        System.out.println("================");

        //Titles
        for (Element el : divs3) {
            log("Title3: %s", el.text());
        }

        System.out.println("============");
        //Cites
        for (Element el : cites3) {
            log("Cites3: %s", el.text());
        }

        System.out.println("============");
        //Prices
        for (Element el : prices3) {
            log("Price3: %s", el.text());
        }

        System.out.println("============");
        //Description
        for (Element el : descs3) {
            log("Desc3: %s", el.text());
        }

    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
