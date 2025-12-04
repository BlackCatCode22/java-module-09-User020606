package com.example.Demo.demo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)


@RestController


    public class Controller {

    @RequestMapping("/greet")
    public String getCity() {
        return "Hello welcome to the weather app! Pick a city that you would like to see.";
    }


    private List<City> cities;

    public Controller() {
        cities = new ArrayList<>();

        // Hard-coded cities
        cities.add(new City("Fresno", 36.7378, -119.7871));
        cities.add(new City("Los Angeles", 34.0522, -118.2437));
        cities.add(new City("New York", 40.7128, -74.0060));
    }

    public List<City> getCities() {
        return cities;
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        // Print all cities
        for (City c : controller.getCities()) {
            System.out.println(c);
        }
    }


    private double temperature;
    private double windspeed;

    // Getters and setters
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    @Override
    public String toString() {
        return "CurrentWeather" +
                "temperature=" + temperature +
                ", windspeed=" + windspeed +
                '}';
    }


}



