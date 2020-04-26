package orlian.weather;

import com.google.gson.Gson;
import orlian.earthquakes.CurrentEarthquakes;

import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

public class GetCurrentWeather {

    public static void main(String[] args) throws IOException {
        //URL url = new URL("https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22");
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=10977,us&appid=77e9f687f947b4ec730e2cce168c2cc1");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Gson gson = new Gson();
        CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);

        String name = currentWeather.name;
        System.out.println(currentWeather.name);

        String temp = ((int)((((double)currentWeather.main.temp) - 273.15) * (9.0/5) + 32) + " °F");
        System.out.println((int)((((double)currentWeather.main.temp) - 273.15) * (9.0/5) + 32) + " °F");

        for(CurrentWeather.Weather weather : currentWeather.weather) {
            String main = weather.main.toString();
            System.out.println(weather.main.toString());
            String description = weather.description.toString();
            System.out.println(weather.description.toString());
        }
    }
}

