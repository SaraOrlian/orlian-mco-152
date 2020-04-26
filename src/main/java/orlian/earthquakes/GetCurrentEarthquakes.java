package orlian.earthquakes;

import com.google.gson.Gson;
import orlian.weather.CurrentWeather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetCurrentEarthquakes {

    public static void main(String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://earthquake.usgs.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EarthquakeService service = retrofit.create(EarthquakeService.class);

        service.getThisMonth().enqueue(new Callback<CurrentEarthquakes>() {
            @Override
            public void onResponse(Call<CurrentEarthquakes> call, Response<CurrentEarthquakes> response) {
                CurrentEarthquakes currentEarthquakes = response.body();
                for (CurrentEarthquakes.Feature feature : currentEarthquakes.features){
                    System.out.println(feature.properties.toString());
                }
            }

            @Override
            public void onFailure(Call<CurrentEarthquakes> call, Throwable t) {
                    t.printStackTrace();
            }
        });

        //CurrentEarthquakes currentEarthquakes = service.getThisMonth().execute().body();

        /*URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Gson gson = new Gson();
        CurrentEarthquakes currentEarthquakes = gson.fromJson(reader, CurrentEarthquakes.class);
*/
        /*for (CurrentEarthquakes.Feature feature : currentEarthquakes.features){
            System.out.println(feature.properties.toString());
        }*/
    }
}
