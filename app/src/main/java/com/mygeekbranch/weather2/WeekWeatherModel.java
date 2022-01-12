package com.mygeekbranch.weather2;

public class WeekWeatherModel {
    private String date;
    private String temperature;

    public WeekWeatherModel(String date, String temperature) {
        this.date = date;
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
