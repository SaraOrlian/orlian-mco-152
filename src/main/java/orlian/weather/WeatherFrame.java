package orlian.weather;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherFrame extends JFrame {

    private JLabel zipLabel;
    private JTextField zipField;
    private JLabel locationLabel;
    private JLabel tempLabel;
    private JLabel mainLabel;
    private JLabel descriptionLabel;
    private JLabel zipError;
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
        zipError = new JLabel();
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
        add(zipError);
    }

    public void getWeather() throws IOException {
        URL url = null;
        //Thread thread = new Thread() {
        try {
                Integer.parseInt(zipField.getText());
                if (zipField.getText().length() == 5) {
                    url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zipField.getText() + ",us&appid=77e9f687f947b4ec730e2cce168c2cc1");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    Gson gson = new Gson();
                    CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);

                    locationLabel.setText(currentWeather.name);

                    tempLabel.setText((int) ((((double) currentWeather.main.temp) - 273.15) * (9.0 / 5) + 32) + " °F");

                    for (CurrentWeather.Weather weather : currentWeather.weather) {
                        mainLabel.setText(weather.main.toString());
                        descriptionLabel.setText(weather.description.toString());
                    }
                } else {
                    NumberFormatException e;
                }
            }
        catch(
            NumberFormatException e)

            {
                zipError.setText("Not a valid zip code");
            }catch(
            MalformedURLException e)

            {
                e.printStackTrace();
            }
        //};
        //thread.start();
    }

    public static void main(String[] args) {
        WeatherFrame frame = new WeatherFrame();
        frame.setVisible(true);


    }
}
