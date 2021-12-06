package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcRestaurantDao implements RestaurantDao {

    private final RestaurantDao restaurantDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(RestaurantDao restaurantDao, JdbcTemplate jdbcTemplate) {
        this.restaurantDao = restaurantDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {

        return null;
    };

    @Override
    public Restaurant getRestaurantByName(String restaurantName) {

        return null;
    };

    @Override
    public Restaurant getRestaurantByStarRating(int starRating) {

        return null;
    };
}
