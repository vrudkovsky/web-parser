package jsoup;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashSet;
import java.util.Set;

public class PeoplefindersScraper {

	public static void main(String[] args) throws Exception {

		final String lastName = "Smith";
		final String city = "New York";
		final String state = "NY";

		final HttpResponse<String> response = Unirest.get("http://www.peoplefinders.com/GetResults?Latitude=0&Longitude=0&BoundSize=0&MaxRowsSpecified=True&" +
				"MaxRows=80&Rows=10&Start=1&SearchEngineID=2&SearchEngineIDSpecified=True&search=People&" +
				"StateDropDownPlaceholder=State&Widgets=System.Collections.Generic.Dictionary%602%5BSystem.String%2CSystem.Int32%5D&isVoucher=False")
				.queryString("ln", lastName)
				.queryString("LastName", lastName)
				.queryString("city", city)
				.queryString("state", state)
				.asString();

		final Document htmlSnippet = Jsoup.parseBodyFragment(response.getBody());

		for (Element peopleResult : htmlSnippet.select("div.resultRow > div.col-md-12 > div.row > div.col-md-12")) {

			final String name = peopleResult.select("a.name-blue").text();
			final String age = peopleResult.child(1).text();
			final Set<String> relatives = new HashSet<>();

			for (Element relative : peopleResult.child(3).children().select("div > div")) {
				relatives.add(relative.text());
			}

			System.out.println(name + " -> age: " + age + ", relatives: " + String.join(", ", relatives));
		}
	}
}
