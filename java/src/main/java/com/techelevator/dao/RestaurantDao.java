package com.techelevator.dao;

import com.techelevator.model.Restaurant;

import java.sql.Time;
import java.util.List;

public interface RestaurantDao {

    Restaurant getRestaurantById(int restaurantId);

    Restaurant getRestaurantByName(String restaurantName);

    List<Restaurant> getAllRestaurantsByInviteId(int inviteId);

    List<Restaurant> getFinalistsByInviteId(int inviteId);

    void createRestaurant(String restaurantName, String restaurantType, String restaurantAddress, Time openTime,
                          Time closeTime, String phoneNumber, String thumbnailImage, int starRating, boolean takeOut,
                          boolean delivery, boolean vetoed);

    void thumbsDown(int restaurantId);

}
