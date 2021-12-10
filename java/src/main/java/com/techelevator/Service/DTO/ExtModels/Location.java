package com.techelevator.Service.DTO.ExtModels;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Location {
    private String address1;
    private String address2;
    private String address3;
    private String city; //IMPORTANT FILTER

    @JsonProperty("zip_code")
    private String zipCode; //IMPORTANT FILTER
    private String country;
    private String state;


    //GETTERS & SETTERS
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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


    //CONSTRUCTORS
    public Location() {
    }

    @Override
    public String toString() {
        return address1 + " " +  address2 +" " + address3 +" " + city +" " + zipCode +" " + country +" " +  state;
    }
}

