package app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ImmoApp {

    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36";

    public static final ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://www.ouestfrance-immo.com/acheter/maison/saint-christophe-sur-roc-79-79220/")
                .userAgent(USER_AGENT)
                .get();


        Elements annonces = doc.select("a.annLink");
        Elements titles = doc.select("span.annTitre");
        Elements cities = doc.select("span.annVille");
        Elements criterias = doc.select("span.annCriteres");
        Elements prices = doc.select("span.annPrix");



        FileOutputStream fos = new FileOutputStream("immo.csv", true);
        final PrintWriter pw = new PrintWriter(fos);

        pw.println("Title, Cite, Criteria, Price");

        for (int i = 0; i < annonces.size()-1; i++) {
            pw.println(titles.get(i).text() + ", " + cities.get(i).text() + "," + criterias.get(i).text() + ", " + prices.get(i).text());
        }

        pw.close();

    }
}
