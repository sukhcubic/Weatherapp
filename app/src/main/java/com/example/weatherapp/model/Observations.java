package com.example.weatherapp.model;

import java.util.List;

public class Observations {

    private List<Location> location = null;

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

}