package com.example.weatherapp.model;


public class WeatherInfo {
    private Observations observations;
    private String feedCreation;
    private Boolean metric;

    public Observations getObservations() {
        return observations;
    }

    public void setObservations(Observations observations) {
        this.observations = observations;
    }

    public String getFeedCreation() {
        return feedCreation;
    }

    public void setFeedCreation(String feedCreation) {
        this.feedCreation = feedCreation;
    }

    public Boolean getMetric() {
        return metric;
    }

    public void setMetric(Boolean metric) {
        this.metric = metric;
    }

}
