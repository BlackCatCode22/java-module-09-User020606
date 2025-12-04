package com.example.Demo.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;


@RestController
public class Weather {

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {

        // Step 1: define coordinates for each city
        Map<String, double[]> coords = Map.of(
                "Fresno", new double[]{36.7378, -119.7871},
                "Los Angeles", new double[]{34.0522, -118.2437},
                "New York", new double[]{40.7128, -74.0060}
        );

        if (!coords.containsKey(city)) {
            return "City not supported.";
        }

        double lat = coords.get(city)[0];
        double lon = coords.get(city)[1];

        // Step 2: Build Open-Meteo API URL
        String url = "https://api.open-meteo.com/v1/forecast?"
                + "latitude=" + lat
                + "&longitude=" + lon
                + "&current_weather=true";

        // Step 3: Call API
        RestTemplate rt = new RestTemplate();
        try {
            return rt.getForObject(url, String.class);
        } catch (Exception e) {
            return "Error fetching weather: " + e.getMessage();
        }




    }


}

