package com.techelevator.Service.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.Service.DTO.ExtModels.ApiCategories;
import com.techelevator.Service.DTO.ExtModels.Coordinates;
import com.techelevator.Service.DTO.ExtModels.Location;

import java.util.Arrays;

public class RestaurantDTO {

    private String id;
    private String alias;
    private String name;

    @JsonProperty("image_url")
    private String imageUrl;

    private boolean isClosed;
    private String url;
    private ApiCategories[] categories;

    private String[] Transactions; //will need a loop on FE to parse these values
    private String price; //this is yelp $$$ to show price threshold

    private Location location; // need zipcode, city/state --> this is the search filter

    private Coordinates coordinates;

    @JsonProperty("display_phone")
    private String displayPhoneNumber;

    private double rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ApiCategories[] getCategories() {
        return categories;
    }

    public void setCategories(ApiCategories[] categories) {
        this.categories = categories;
    }

    public String[] getTransactions() {
        return Transactions;
    }

    public void setTransactions(String[] transactions) {
        Transactions = transactions;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    //this isn't working in the db for some reason
    public String getDisplayPhoneNumber() {
        return displayPhoneNumber;
    }

    public void setDisplayPhoneNumber(String displayPhoneNumber) {
        this.displayPhoneNumber = displayPhoneNumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public RestaurantDTO() {
    }

//    public String getType(){
//        String result = "";
//        if(categories != null){
//            result = categories[1].getTitle();
//        }
//
//        return result;
//    }


    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "id='" + id + '\'' +
                ", alias='" + alias + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isClosed=" + isClosed +
                ", url='" + url + '\'' +
                ", categories=" + Arrays.toString(categories) +
                ", transactionTypes=" + getTransactions().length +
                ", price='" + price + '\'' +
                ", location=" + location.getZipCode() +
                ", coordinates=" + coordinates.getLatitude() + coordinates.getLongitude() +
                ", displayPhoneNumber='" + displayPhoneNumber + '\'' +
                ", rating=" + rating +
                '}';
    }
}
