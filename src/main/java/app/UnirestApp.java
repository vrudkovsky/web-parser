package app;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class UnirestApp {
    public static void main(String[] args) throws Exception {

        //Change the default user-agent header
        Unirest.setDefaultHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36");

        //Use a proxy
        Unirest.setProxy(new HttpHost("20.195.17.90", 3128));

        //Making a simple get request to httpbin.org
        final HttpResponse<JsonNode> getResponse = Unirest.get("http://httpbin.org/get").queryString("limit", 10).asJson();

        System.out.println("IP-Address: " + getResponse.getBody().getObject().getString("origin"));
        System.out.println("User-Agent: " + getResponse.getBody().getObject().getJSONObject("headers").getString("User-Agent"));


        System.out.println("\n\n---------------------\n\n");


        //Make a post request with form data
        final HttpResponse<String> postResponseOne = Unirest.post("http://httpbin.org/post").field("postalcode", 12345).asString();

        System.out.println(postResponseOne.getBody());

        System.out.println("\n\n---------------------\n\n");


        //Make a post request with body data (Json)
        final JSONObject exampleJson = new JSONObject().put("postalcode", 12345);

        final HttpResponse<String> postResponseTwo = Unirest.post("http://httpbin.org/post").body(exampleJson).asString();

        System.out.println(postResponseTwo.getBody());
    }
}
