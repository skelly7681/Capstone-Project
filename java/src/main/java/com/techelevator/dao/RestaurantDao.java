package com.techelevator.dao;

import com.techelevator.Service.DTO.RestaurantDTO;
import com.techelevator.model.Restaurant;

import java.sql.Time;
import java.util.List;

public interface RestaurantDao {

    Restaurant getRestaurantById(int restaurantId);

    Restaurant getRestaurantByName(String restaurantName);

    List<Restaurant> getAllRestaurantsByInviteId(int inviteId);

    List<Restaurant> getFinalistsByInviteId(int inviteId);

    int createRestaurant(RestaurantDTO restaurant);

    void thumbsDown(int restaurantId, int inviteId);

}