package com.techelevator.dao;

import com.techelevator.model.Restaurant;

import java.util.List;

public interface RestaurantDao {

    Restaurant getRestaurantById(int restaurantId);

    Restaurant getRestaurantByName(String restaurantName);

    List<Restaurant> getAllRestaurantsByInviteId(int inviteId);

    List<Restaurant> getFinalistsByInviteId(int inviteId);

    Restaurant createRestaurant();

    void thumbsDown(int restaurantId);

}
