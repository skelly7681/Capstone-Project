package com.techelevator.dao;

import com.techelevator.Service.DTO.ExtModels.ApiCategories;
import com.techelevator.Service.DTO.RestaurantDTO;
import com.techelevator.model.Invite;
import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRestaurantDao implements RestaurantDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {

        Restaurant restaurant = null;

        String sql = "SELECT r.restaurant_id, r.restaurant_name, r.restaurant_type, r.restaurant_address, " +
                "r.phone_number, r.thumbnail_img, r.star_rating, r.take_out, r.delivery, ir.vetoed " +
                "FROM restaurants r " +
                "JOIN invite_restaurant ir ON r.restaurant_id = ir.restaurant_id " +
                "WHERE r.restaurant_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, restaurantId);
        if (results.next()) {
            restaurant = mapRowToRestaurant(results);
        }

        return restaurant;
    };

    @Override
    public Restaurant getRestaurantByName(String restaurantName) {

        Restaurant restaurant = null;

        String sql = "SELECT r.restaurant_id, r.restaurant_name, r.restaurant_type, r.restaurant_address, " +
                "r.phone_number, r.thumbnail_img, r.star_rating, r.take_out, r.delivery " +
                "FROM restaurants r " +
                "WHERE r.restaurant_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, restaurantName);
        if (results.next()) {
            restaurant = mapRowToRestaurant(results);
        }

        return restaurant;
    };

    @Override
    public List<Restaurant> getAllRestaurantsByInviteId(int inviteId) {

        List<Restaurant> restaurants = new ArrayList<>();

        String sql = "SELECT r.restaurant_id, r.restaurant_name, r.restaurant_type, r.restaurant_address, " +
                "r.phone_number, r.thumbnail_img, r.star_rating, r.take_out, r.delivery, ir.vetoed " +
                "FROM restaurants r " +
                "JOIN invite_restaurant ir ON r.restaurant_id = ir.restaurant_id " +
                "WHERE ir.invite_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, inviteId);
        while (results.next()){
            Restaurant restaurant = mapRowToRestaurant(results);
            restaurants.add(restaurant);
        }

        return restaurants;
    }



    @Override
    public List<Restaurant> getFinalistsByInviteId(int inviteId) {

        List<Restaurant> restaurants = new ArrayList<>();

        String sql = "SELECT r.restaurant_id, r.restaurant_name, r.restaurant_type, r.restaurant_address, " +
                "r.phone_number, r.thumbnail_img, r.star_rating, r.take_out, r.delivery, ir.vetoed " +
                "FROM restaurants r " +
                "JOIN invite_restaurant ir ON r.restaurant_id = ir.restaurant_id " +
                "WHERE ir.invite_id = ? AND ir.vetoed = false";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, inviteId);
        while (results.next()){
            Restaurant restaurant = mapRowToRestaurant(results);
            restaurants.add(restaurant);
        }

        return restaurants;

    }


    @Override
    public int createRestaurant(RestaurantDTO restaurant) {

        Restaurant checkerRestaurant = getRestaurantByName(restaurant.getName()); //not great but it works
        int restaurantId = 0;

        //for-loop to take-out / delivery
        boolean hasTakeOut = false;
        boolean hasDelivery = false;

        String[] transactions = restaurant.getTransactions();
        for (String transaction : transactions){
            if (transaction.equalsIgnoreCase("pickup")){
                hasTakeOut = true;
            }

            if(transaction.equalsIgnoreCase("delivery")){
                hasDelivery = true;
            }
        }

        //for-loop to get get type
        ApiCategories[] categories = restaurant.getCategories();
        String type = categories[0].getTitle();

        if(checkerRestaurant == null){
            String sql = "INSERT INTO restaurants (restaurant_name, restaurant_type, restaurant_address, " +
                    "phone_number, thumbnail_img, star_rating, take_out, delivery, yelp_key) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            jdbcTemplate.update(sql, restaurant.getName(), type,  restaurant.getLocation().toString(), restaurant.getDisplayPhoneNumber(),
                    restaurant.getImageUrl(), restaurant.getRating(), hasTakeOut, hasDelivery, restaurant.getId());

            restaurantId = getRestaurantByName(restaurant.getName()).getRestaurantId();

        } else {
            restaurantId = checkerRestaurant.getRestaurantId();
        }

        return restaurantId;

    }

    @Override  // this SQL statement is broken
    public void thumbsDown(int inviteId, int restaurantId) {

        //need to add invite_id and take out the join
        String sql = "UPDATE invite_restaurant " +
                "SET vetoed = false " +
                "WHERE invite_id = ? AND restaurant_id = ?";


        jdbcTemplate.update(sql, inviteId, restaurantId);
    }

    private Restaurant mapRowToRestaurant(SqlRowSet rs) {

        Restaurant restaurant = new Restaurant();

        restaurant.setRestaurantId(rs.getInt("restaurant_id"));
        restaurant.setRestaurantName(rs.getString("restaurant_name"));
        restaurant.setRestaurantType(rs.getString("restaurant_type"));
        restaurant.setRestaurantAddress(rs.getString("restaurant_address"));
        restaurant.setPhoneNumber(rs.getString("phone_number"));
        restaurant.setThumbnailImage(rs.getString("thumbnail_img"));

        Double starValue = rs.getDouble("star_rating");
        restaurant.setStarRating(starValue.intValue());

        restaurant.setTakeOut(rs.getBoolean("take_out"));
        restaurant.setDelivery(rs.getBoolean("delivery"));


        return restaurant;
    }
}
