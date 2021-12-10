package com.techelevator.Service.DTO.ExtModels;

//this doesn't work - weird type matching

public class Coordinates {

    private float latitude;
    private float longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Coordinates() {
    }
}

