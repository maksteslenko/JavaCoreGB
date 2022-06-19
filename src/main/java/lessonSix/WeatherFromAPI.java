package lessonSix;

import okhttp3.*;
import java.io.IOException;

public class WeatherFromAPI {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        String cityId = "295212";

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", "HdLFGyNLPeQl3AfDDQVkJYGq1uaj3reA")
                .addQueryParameter("language", "ru")
                .addQueryParameter("details", "false")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();
        System.out.println(responseBody);
    }
}
