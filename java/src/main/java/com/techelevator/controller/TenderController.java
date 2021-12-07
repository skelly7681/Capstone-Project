package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.Restaurant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController

public class TenderController {

    private final UserDao userDao;
    private final InviteDao inviteDao;
    private final RestaurantDao restaurantDao;

    public TenderController(UserDao userDao, RestaurantDao restaurantDao, InviteDao inviteDao) {

        this.userDao = userDao;
        this.restaurantDao = restaurantDao;
        this.inviteDao = inviteDao;

    }

    //Get All Restaurants by invite
    @RequestMapping(path = "/restaurants", method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurantsById(int restaurantId) {
        return restaurantDao.getRestaurantById(restaurantId);
    }



}
