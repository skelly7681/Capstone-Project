package com.techelevator.model;

import java.sql.Time;
import java.util.List;

public class Restaurant {

    private int restaurantId;
    private String yelpKey;
    private String restaurantName;
    private String restaurantType;
    private String restaurantAddress;
    private String phoneNumber;
    private String thumbnailImage;
    private int starRating;
    private boolean takeOut;
    private boolean delivery;


    public Restaurant(int restaurantId, String restaurantName, String restaurantType, String restaurantAddress, String phoneNumber, String thumbnailImage, int starRating, boolean takeOut, boolean delivery) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantType = restaurantType;
        this.restaurantAddress = restaurantAddress;
        this.phoneNumber = phoneNumber;
        this.thumbnailImage = thumbnailImage;
        this.starRating = starRating;
        this.takeOut = takeOut;
        this.delivery = delivery;
    }

    public Restaurant() {}

    public Integer getRestaurantId() {
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

    public String getYelpKey() {
        return yelpKey;
    }

    public void setYelpKey(String yelpKey) {
        this.yelpKey = yelpKey;
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", yelpKey='" + yelpKey + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantType='" + restaurantType + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", thumbnailImage='" + thumbnailImage + '\'' +
                ", starRating=" + starRating +
                ", takeOut=" + takeOut +
                ", delivery=" + delivery +
                '}';
    }
}
