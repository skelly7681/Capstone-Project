package com.techelevator.dao;

import com.techelevator.model.Restaurant;

import java.sql.Time;
import java.util.List;

public interface RestaurantDao {

    Restaurant getRestaurantById(int restaurantId);

    Restaurant getRestaurantByName(String restaurantName);

    List<Restaurant> getAllRestaurantsByInviteId(int inviteId);

    List<Restaurant> getFinalistsByInviteId(int inviteId);

    void createRestaurant(String restaurantName, String restaurantType, String restaurantAddress, String phoneNumber, String thumbnailImage, double starRating, boolean takeOut,
                          boolean delivery, String yelpKey);

    void thumbsDown(int restaurantId);

}