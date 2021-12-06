package com.techelevator.controller;

import com.techelevator.dao.*;

public class TenderController {

    private final UserDao userDao;
    private final InviteDao inviteDao;
    private final RestaurantDao restaurantDao;

    public TenderController(UserDao userDao, RestaurantDao restaurantDao, InviteDao inviteDao) {

        this.userDao = userDao;
        this.restaurantDao = restaurantDao;
        this.inviteDao = inviteDao;

    }
}
