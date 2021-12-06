package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcRestaurantDao implements RestaurantDao {

    private final RestaurantDao restaurantDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(RestaurantDao restaurantDao, JdbcTemplate jdbcTemplate) {
        this.restaurantDao = restaurantDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Restaurant getRestaurantById(int restaurantId) {

        Restaurant restaurant = null;

        String sql = "SELECT restaurant_name, restaurant_type, restaurant_address, open_time, close_time, phone_number, thumbnail_img, " +
                "star_rating, take_out, delivery " +
                "FROM restaurants " +
                "WHERE restaurant_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, restaurantId);
        if (results.next()) {
            restaurant = mapRowToRestaurant(results);
        }

        return restaurant;
    };

    public Restaurant getRestaurantByName(String restaurantName) {

        Restaurant restaurant = null;

        String sql = "SELECT restaurant_id, restaurant_type, restaurant_address, open_time, close_time, phone_number, thumbnail_img, " +
                "star_rating, take_out, delivery " +
                "FROM restaurants " +
                "WHERE restaurant_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, restaurantName);
        if (results.next()) {
            restaurant = mapRowToRestaurant(results);
        }

        return restaurant;
    };

    public Restaurant getRestaurantByStarRating(int starRating) {

        return null;
    };

    private Restaurant mapRowToRestaurant(SqlRowSet rs) {

        Restaurant restaurant = new Restaurant();

        restaurant.setRestaurantId(rs.getInt("restaurant_id"));
        restaurant.setRestaurantName(rs.getString("restaurant_name"));
        restaurant.setRestaurantType(rs.getString("restaurant_type"));
        restaurant.setRestaurantAddress(rs.getString("restaurant_address"));
        restaurant.setOpenTime(rs.getTime("open_time"));
        restaurant.setCloseTime(rs.getTime("close_time"));
        restaurant.setPhoneNumber(rs.getNString("phone_number"));
        restaurant.setThumbnailImage(rs.getString("thumbnail_img"));
        restaurant.setStarRating(rs.getInt("star_rating"));
        restaurant.setTakeOut(rs.getBoolean("take_out"));
        restaurant.setDelivery(rs.getBoolean("delivery"));

        return restaurant;
    }
}
