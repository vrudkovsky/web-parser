package app;
import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static String[] urls = new String[] {
            "https://www.ouestfrance-immo.com/acheter/maison/saint-christophe-sur-roc-79-79220/",
            "https://www.paruvendu.fr/immobilier/annonceimmofo/liste/listeAnnonces?tt=1&tbApp=1&tbDup=1&tbChb=1&tbLof=1&tbAtl=1&tbPla=1&tbMai=1&tbVil=1&tbCha=1&tbPro=1&tbHot=1&tbMou=1&tbFer=1&at=1&nbp0=99&pa=FR&lol=0&ray=50&codeINSEE=79191",
            "http://pogoda.spb.ru/",
            "https://www.leboncoin.fr/recherche?category=9&locations=Niort_79000__46.32125_-0.46338_6409",
            "https://www.seloger.com/"
    };
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36";



    private static Document getPage() throws IOException {
//        String url = "http://pogoda.spb.ru/";
        Document page = Jsoup.parse(new URL(urls[3]), 3000);
        return page;
    }
    private static Document getPagev2() throws IOException {
        Document page = Jsoup.connect(urls[0]).userAgent(USER_AGENT).get();
        return page;
    }

    private static Pattern p = Pattern.compile("\\d{2}\\.\\d{2}");

    private static String getDateFromString(String s) throws Exception {
        Matcher m = p.matcher(s);
        if (m.find()) {
            return m.group();
        }
        throw new Exception("Can't get date from string");

    }

    public static void downloadPage() throws Exception {
        final Connection.Response response = Jsoup.connect(urls[4]).execute();
        final Document doc = response.parse();

        final File f = new File("parsed.html");
        FileUtils.writeStringToFile(f, doc.outerHtml(), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
        Document page = getPagev2();
        System.out.println(page.outerHtml());



//        Elements names = page.getElementsByClass("container");
//        Elements links = page.getElementsByClass("voirann");
//        System.out.println(names);
//        System.out.println(links);


//        Element tw = page.getElementsByClass("wt").first();
//        Elements names = page.getElementsByClass("wth");
//        Elements values = page.getElementsByAttributeValue("valign", "top");
//
//        int index = 0;
//
//        for (Element name : names) {
//            String ds = name.getElementById("dt").text();
//            String date = getDateFromString(ds);
//            System.out.println(date + "    Явления    Темпиратура    Давл    Влажность    Ветер");
//        }


        //        downloadPage();
    }
}
