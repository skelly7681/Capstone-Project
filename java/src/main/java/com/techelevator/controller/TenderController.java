<<<<<<< HEAD
//package com.techelevator.controller;
//
//import com.techelevator.dao.*;
//
//public class TenderController {
//
//    private final UserDao userDao;
//    private final InviteDao inviteDao;
//    private final RestaurantDao restaurantDao;
//
//    public TenderController(UserDao userDao, RestaurantDao restaurantDao, InviteDao inviteDao) {
//
//        this.userDao = userDao;
//        this.restaurantDao = restaurantDao;
//        this.inviteDao = inviteDao;
//
//    }
//}
=======
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

    @RequestMapping(path = "/restaurants", method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurantsByInviteId(int restaurantId) {
        return restaurantDao.getAllRestaurantsByInviteId(restaurantId);
    }



}
>>>>>>> 89485d7b4cf3b31c45b7fbb6dbd5bc4ae579b32d
