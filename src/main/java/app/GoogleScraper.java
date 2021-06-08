package app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.PrintWriter;
import java.net.URLEncoder;

public class GoogleScraper {

    //URL: https://www.google.com/search?q=apple
    //Selector: h3.r a
    //Selector: div.yuRUbf a

    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36";

    public static void main(String[] args) throws Exception {

        final String query = "apple";

        final Document page = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8")).userAgent(USER_AGENT).get();

        final PrintWriter out = new PrintWriter("results.csv");

        for (Element searchResult : page.select("div.yuRUbf a")) {

            final String title = searchResult.select("h3.LC20lb").text();
            final String url = searchResult.attr("href");
            out.write(title + " -> " + url + "\n");
        }

        out.close();
    }
}
