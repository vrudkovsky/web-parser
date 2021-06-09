package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.naming.directory.SearchResult;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ExportJson {

    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        final String query = "apple";

        final Document page = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8")).userAgent(USER_AGENT).get();

        final List<SearchResult> resultList = new ArrayList<SearchResult>();

        for (Element searchResult : page.select("h3.r a")) {

            final String title = searchResult.text();
            final String url = searchResult.attr("href");

            resultList.add(new SearchResult(title, url));
        }

        OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File("results.json"), resultList);
    }
}
