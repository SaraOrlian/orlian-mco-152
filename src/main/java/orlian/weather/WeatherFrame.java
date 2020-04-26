package orlian.weather;

import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

public class WeatherFrame extends JFrame {

    private JLabel zipLabel;
    private JTextField zipField;
    private JLabel locationLabel;
    private JLabel tempLabel;
    private JLabel mainLabel;
    private JLabel descriptionLabel;
    private JButton getWeatherButton;

    public WeatherFrame(){

        setSize(300, 300);
        setTitle("Weather Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        zipLabel = new JLabel("Enter a zip code:");
        zipField = new JTextField();
        zipField.setPreferredSize(new Dimension( 100, 40));
        getWeatherButton = new JButton("Get Weather");

        getWeatherButton.addActionListener(actionEvent -> {
            try {
                getWeather();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        locationLabel = new JLabel();
        tempLabel = new JLabel();
        mainLabel = new JLabel();
        descriptionLabel = new JLabel();
        locationLabel.setPreferredSize(new Dimension(100, 40));
        tempLabel.setPreferredSize(new Dimension(100, 40));
        mainLabel.setPreferredSize(new Dimension(100, 40));
        descriptionLabel.setPreferredSize(new Dimension(100, 40));
        locationLabel.setOpaque(true);
        tempLabel.setOpaque(true);
        mainLabel.setOpaque(true);
        descriptionLabel.setOpaque(true);
        add(zipLabel);
        add(zipField);
        add(getWeatherButton);
        add(locationLabel);
        add(tempLabel);
        add(mainLabel);
        add(descriptionLabel);
    }

    public void getWeather() throws IOException {
        URL url = null;
        try {
                Integer.parseInt(zipField.getText());
                if (zipField.getText().length() == 5) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://api.openweathermap.org/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    WeatherService service = retrofit.create(WeatherService.class);

                    service.getCurrentWeather(zipField.getText()).enqueue(new Callback<CurrentWeather>() {
                        @Override
                        public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                            CurrentWeather currentWeather = response.body();

                            locationLabel.setText(currentWeather.name);
                            tempLabel.setText(((int)currentWeather.main.temp) + " " + "\u00B0" +"F");
                            for(CurrentWeather.Weather weather : currentWeather.weather) {
                                mainLabel.setText(weather.main);
                                descriptionLabel.setText(weather.description);
                            }
                            }

                        @Override
                        public void onFailure(Call<CurrentWeather> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                   } else {  //when zip is not 5 digits
                    reset();
                    locationLabel.setText("Not a valid zip code");
                }
            }
        catch(NumberFormatException e)  //when zip is not a number
            {
                reset();
                locationLabel.setText("Not a valid zip code");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }

    public void reset(){
        locationLabel.setText("");
        tempLabel.setText("");
        mainLabel.setText("");
        descriptionLabel.setText("");
        }

    public static void main(String[] args) {
        WeatherFrame frame = new WeatherFrame();
        frame.setVisible(true);


    }
}
