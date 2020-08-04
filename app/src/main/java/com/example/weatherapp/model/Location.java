package com.example.weatherapp.model;

import java.util.List;

public class Location {
    private List<Observation> observation = null;
    private String country;
    private String state;
    private String city;
    private Double latitude;
    private Double longitude;
    private Integer distance;
    private Integer timezone;

    public List<Observation> getObservation() {
        return observation;
    }

    public void setObservation(List<Observation> observation) {
        this.observation = observation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

}
