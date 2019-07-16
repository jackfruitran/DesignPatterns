package com.zhangxinran.ObServer.ObServerJava;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(85, 75, 32.4f);
        weatherData.setMeasurements(90, 30, 11.2f);
        int i = weatherData.countObservers();
        System.out.println(i);

    }
}
