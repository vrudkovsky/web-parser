package app;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class REScraper {
    public static void main(String[] args) throws Exception{
//        final HttpResponse<String> response = Unirest.get("https://api.leboncoin.fr/finder/search").asString();

        HttpResponse<String> response = Unirest
                .post("https://api.leboncoin.fr/finder/search")
                .header("cache-control", "no-cache")
                .header("api_key", "ba0c2dad52b3ec")
                .header("Content-Type", "application/json")
                .body("{some JSON body}")
                .asString();
        System.out.println(response.getBody());

    }
}
