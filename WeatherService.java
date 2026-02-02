import java.net.*;
import java.io.*;

public class WeatherService {
    public static String getWeather() {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Dehradun&appid=YOUR_FREE_KEY&units=metric");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response = reader.readLine():
            String temp = response.split(""temp":")[1].split(",")[0];
            return "Dehradun is " + temp + " degrees Celsius";
        } catch (Exception e) {
            return "Weather service temporarily unavailable";
        }
    }
}
