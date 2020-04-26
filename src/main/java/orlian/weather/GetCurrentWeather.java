package orlian.weather;

import com.google.gson.Gson;
import orlian.earthquakes.CurrentEarthquakes;
import orlian.earthquakes.EarthquakeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

public class GetCurrentWeather {

    public static void main(String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);
        String zip = "10977";
        service.getCurrentWeather(zip).enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                CurrentWeather currentWeather = response.body();
                for(CurrentWeather.Weather weather : currentWeather.weather) {
                    String main = weather.main;
                    System.out.println(weather.main);
                    String description = weather.description;
                    System.out.println(weather.description);
                    }
                String name = currentWeather.name;
                System.out.println(currentWeather.name);
                System.out.println(((int)currentWeather.main.temp) + " " + "\u00B0" +"F");
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}

