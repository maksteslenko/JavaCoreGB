package lessonSeven.project;

import java.io.IOException;

public interface WeatherModel {
     void getWeather(String city, Period period) throws IOException;
     boolean isCityValid(String city) throws IOException;
     boolean isCommandValid(String command);
}
