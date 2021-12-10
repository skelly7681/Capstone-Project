package com.techelevator.Service.DTO;


import com.techelevator.Service.DTO.ExtModels.ApiCategories;
import com.techelevator.Service.DTO.ExtModels.Coordinates;
import com.techelevator.Service.DTO.ExtModels.Location;
import com.techelevator.Service.DTO.ExtModels.Transactions;

import java.util.Map;

public class RestaurantDTO {

    private String id;
    private String alias;
    private String name;
    private String imageUrl;
    private boolean isClosed;
    private String url;
    private ApiCategories[] categories;

    //this isn't mapping correctly
    private Transactions[] transactionTypes;

    private String price; //this is yelp $$$ to show price threshold

    private Location location; // need zipcode, city/state --> this is the search filter

//    private Coordinates[] coordinates;
    private String phoneNumber;
    private String displayPhoneNumber;

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

    public Transactions[] getTransactionTypes() {
        return transactionTypes;
    }

    public void setTransactionTypes(Transactions[] transactionTypes) {
        this.transactionTypes = transactionTypes;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDisplayPhoneNumber() {
        return displayPhoneNumber;
    }

    public void setDisplayPhoneNumber(String displayPhoneNumber) {
        this.displayPhoneNumber = displayPhoneNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //    public Coordinates[] getCoordinates() {
//        return coordinates;
//    }
//
//    public void setCoordinates(Coordinates[] coordinates) {
//        this.coordinates = coordinates;
//    }

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




}
