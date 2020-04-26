package orlian.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("data/2.5/weather?zip+,us&appid=77e9f687f947b4ec730e2cce168c2cc1&units=imperial")
    public Call<CurrentWeather> getCurrentWeather(@Query("zip") String zip);

}
