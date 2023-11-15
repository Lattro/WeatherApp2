package com.example.wetherapp;

public class City
{
    private String name;
    private String longitude;
    private String latitude;

    public String getName() {
        return name;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public City(String name, String longitude, String latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public City()
    {
    }
}
