
package com.techelevator.controller;

import com.techelevator.Service.RestaurantService;
import com.techelevator.dao.*;
import com.techelevator.model.Invite;
import com.techelevator.model.Restaurant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class TenderController {

    private final UserDao userDao;
    private final InviteDao inviteDao;
    private final RestaurantDao restaurantDao;
    private RestaurantService rs;

    public TenderController(UserDao userDao, RestaurantDao restaurantDao, InviteDao inviteDao, RestaurantService restaurantService) {

        this.userDao = userDao;
        this.restaurantDao = restaurantDao;
        this.inviteDao = inviteDao;
        this.rs = restaurantService;

    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path= "/restaurants/{restaurantId}", method = RequestMethod.GET)
    public Restaurant getRestaurantById(int restaurantId) {

        return restaurantDao.getRestaurantById(restaurantId);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/restaurants", method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurantsByInviteId(int inviteId) {

        return restaurantDao.getAllRestaurantsByInviteId(inviteId);
    }

//    @PreAuthorize("hasRole('USER')")
//    @RequestMapping(path = "/restaurants", method = RequestMethod.GET)
//    public List<Restaurant> getFinalistsByInviteId(int inviteId) {
//
//        return restaurantDao.getFinalistsByInviteId(inviteId);
//    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/restaurants/{restaurantId}", method = RequestMethod.PUT)
    public void thumbsDown(int restaurantId) {

        restaurantDao.thumbsDown(restaurantId);

        //Do we need a @RequestBody here if we're only changing one variable?
    }

    // Restaurant method/Invite method Divider //

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/invites/{inviteId}", method = RequestMethod.GET)
    public Invite getInviteByInviteId(int inviteId) {

        return inviteDao.getInviteByInviteId(inviteId);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/invites", method = RequestMethod.GET)
    public List<Invite> getAllInvitesBySenderId(int senderUserId) {

        return inviteDao.getAllInvitesBySenderId(senderUserId);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public Restaurant getYelpTest() {

        return rs.getBasic();
    }

}

