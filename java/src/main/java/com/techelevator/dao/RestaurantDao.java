package com.techelevator.dao;

import com.techelevator.model.Restaurant;

public interface RestaurantDao {

    Restaurant getRestaurantById(int restaurantId);

    Restaurant getRestaurantByName(String restaurantName);

    Restaurant getRestaurantByStarRating(int starRating);

}
