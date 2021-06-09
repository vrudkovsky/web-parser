import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.PrintWriter;
import java.net.URLEncoder;

public class ExportCSV {

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";

    public static void main(String[] args) throws Exception {

        final String query = "apple";

        //Downlaod the page and parse it
        final Document page = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8")).userAgent(USER_AGENT).get();

        //Export the data as CSV
        final PrintWriter out = new PrintWriter("results.csv");

        out.write("Title; URL\n");

        for (Element searchResult : page.select("h3.r a")) {

            final String title = searchResult.text();
            final String url = searchResult.attr("href");

            out.write(title + "; " + url + "\n");
        }

        out.close();
    }
}
