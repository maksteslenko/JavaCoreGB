package lessonSeven.project;

import java.util.List;

public class WeatherResponse {
    String city;
    List<String> date;
    List<Double> temperatureMin;
    List<Double> temperatureMax;
    List<String> weatherDay;
    List<String> weatherNight;

    public void setTemperatureMin(List<Double> temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public void setTemperatureMax(List<Double> temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public void setWeatherDay(List<String> weatherDay) {
        this.weatherDay = weatherDay;
    }

    public void setWeatherNight(List<String> weatherNight) {
        this.weatherNight = weatherNight;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuffer weatherForecast = new StringBuffer();
        for (int i = 0; i < date.size(); i++) {
            weatherForecast.append("Погода в городе " + city + " на " + date.get(i).split("T")[0]
                    + " - макс.температура: " + temperatureMax.get(i) + " °С,"
                    + " мин.температура: " + temperatureMin.get(i) + " °С,"
                    + " днём: " + weatherDay.get(i) + ", ночью: " + weatherNight.get(i) + "\n");
        }
        return weatherForecast.toString();
    }
}
