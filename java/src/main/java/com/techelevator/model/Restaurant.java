package com.techelevator.model;


import java.sql.Time;

public class Restaurant {

    private int restaurantId;
    private String restaurantName;
    private String restaurantType;
    private String restaurantAddress;
    private Time openTime;
    private Time closeTime;
    private String phoneNumber;
    private String thumbnailImage;
    private int starRating;
    private boolean takeOut;
    private boolean delivery;

    // Gonna rip this from a JOIN on invite-restaurant

    private boolean vetoed;

    public Restaurant(int restaurantId, String restaurantName, String restaurantType, String restaurantAddress, Time openTime, Time closeTime, String phoneNumber, String thumbnailImage, int starRating, boolean takeOut, boolean delivery) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantType = restaurantType;
        this.restaurantAddress = restaurantAddress;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.phoneNumber = phoneNumber;
        this.thumbnailImage = thumbnailImage;
        this.starRating = starRating;
        this.takeOut = takeOut;
        this.delivery = delivery;
    }
    public Restaurant() {}

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public boolean isTakeOut() {
        return takeOut;
    }

    public void setTakeOut(boolean takeOut) {
        this.takeOut = takeOut;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    // Getter and setter for that ripped property

    public boolean isVetoed() {
        return vetoed;
    }

    public void setVetoed(boolean vetoed) {
        this.vetoed = vetoed;
    }
}
