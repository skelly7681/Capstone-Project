package com.techelevator.Service.DTO;


import java.util.Map;

public class RestaurantDTO {

    private String id;
    private String alias;
    private String name;
    private boolean isClosed;
    private String url;
//    private Map<String, String> categories;
//    private Map<String, String> transactionTypes;
    private String price; //this is yelp $$$ to show price threshold
//    private Map<String, String> location; // need zipcode, city/state --> this is the search filter
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

//    public Map<String, String> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(Map<String, String> categories) {
//        this.categories = categories;
//    }
//
//    public Map<String, String> getTransactionTypes() {
//        return transactionTypes;
//    }

//    public void setTransactionTypes(Map<String, String> transactionTypes) {
//        this.transactionTypes = transactionTypes;
//    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    public Map<String, String> getLocation() {
//        return location;
//    }
//
//    public void setLocation(Map<String, String> location) {
//        this.location = location;
//    }

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

    public RestaurantDTO() {
    }
}
