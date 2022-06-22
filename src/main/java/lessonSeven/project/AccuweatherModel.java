package lessonSeven.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String API_KEY = "GD6fDyy4mysbQzMLdQOBGYfFSkT8WvkU";
    private static final String LANGUAGE_QUERY_PARAM = "language";
    private static final String LANGUAGE = "ru";
    private static final String METRIC_QUERY_PARAM = "metric";
    private static final String METRIC = "true";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(String city, Period period) throws IOException {
        switch (period) {
            case NOW:
                String oneDayResponse = sendRequest(detectCity(city), ONE_DAY);
                System.out.println(generateWeatherForecast(oneDayResponse, 1, city));
                break;
            case FIVE_DAYS:
                String fiveDaysResponse = sendRequest(detectCity(city), FIVE_DAYS);
                System.out.println(generateWeatherForecast(fiveDaysResponse, 5, city));
                break;
        }
    }

    private String sendRequest(String city, String daysAmount) throws IOException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(DAILY)
                .addPathSegment(daysAmount)
                .addPathSegment(city)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                .addQueryParameter(METRIC_QUERY_PARAM, METRIC)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    private String detectCity(String cityName) throws IOException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", cityName)
                .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response cityCodeResponseJson = okHttpClient.newCall(request).execute();
        String cityCodeResponseString = cityCodeResponseJson.body().string();
        String cityCode;
        if (cityCodeResponseString.contains("LocalizedName")) {
            cityCode = objectMapper.readTree(cityCodeResponseString).get(0).at("/Key").asText();
        } else cityCode = "null";
        return cityCode;
    }

    public boolean isCommandValid(String command) {
        return (command.equals("1") || command.equals("5") || command.equals("0"));
    }

    public boolean isCityValid(String city) throws IOException {
        return !detectCity(city).equals("null");
    }

    public String generateWeatherForecast(String response, int countOfDays, String city) throws JsonProcessingException {
        WeatherResponse weatherResponse = new WeatherResponse();
        List<String> date = new ArrayList<>();
        List<Double> temperatureMin = new ArrayList<>();
        List<Double> temperatureMax = new ArrayList<>();
        List<String> weatherDay = new ArrayList<>();
        List<String> weatherNight = new ArrayList<>();
        for (int i = 0; i < countOfDays; i++) {
            date.add(objectMapper.readTree(response).at("/DailyForecasts").get(i).at("/Date").asText());
            temperatureMin.add(objectMapper.readTree(response).at("/DailyForecasts").get(i)
                    .at("/Temperature/Minimum/Value").asDouble());
            temperatureMax.add(objectMapper.readTree(response).at("/DailyForecasts").get(i)
                    .at("/Temperature/Maximum/Value").asDouble());
            weatherDay.add(objectMapper.readTree(response).at("/DailyForecasts").get(i)
                    .at("/Day/IconPhrase").asText());
            weatherNight.add(objectMapper.readTree(response).at("/DailyForecasts").get(i)
                    .at("/Night/IconPhrase").asText());
        }
        weatherResponse.setCity(city);
        weatherResponse.setDate(date);
        weatherResponse.setTemperatureMin(temperatureMin);
        weatherResponse.setTemperatureMax(temperatureMax);
        weatherResponse.setWeatherDay(weatherDay);
        weatherResponse.setWeatherNight(weatherNight);
        return weatherResponse.toString();
    }
}
