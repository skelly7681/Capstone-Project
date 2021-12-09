
package com.techelevator.controller;

import com.techelevator.Service.RestaurantService;
import com.techelevator.dao.*;
import com.techelevator.model.Invite;
import com.techelevator.model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    //DATABASE
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/restaurants/{restaurantId}", method = RequestMethod.PUT)
    public void thumbsDown(int restaurantId) {

        restaurantDao.thumbsDown(restaurantId);

        //Do we need a @RequestBody here if we're only changing one variable?
    }

    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/restaurants/restaurant", method = RequestMethod.POST)
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantDao.createRestaurant(restaurant.getRestaurantName(), restaurant.getRestaurantType(), restaurant.getRestaurantAddress(),
                restaurant.getOpenTime(), restaurant.getCloseTime(), restaurant.getPhoneNumber(), restaurant.getThumbnailImage(),
                restaurant.getStarRating(), restaurant.isTakeOut(), restaurant.isDelivery(), restaurant.getYelpKey());
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


    //THIRD PARTY API!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //THIS IS A TEST!!! TESTING 3rd PARTY API
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public Restaurant getYelpTest() {
        return rs.getAllRestaurants();
    }


    //-------- BASIC RESTAURANT SEARCH ---------------------------------------
    //need a unique end point to bring restaurants up to the front for viewing
    // user selects their choices, that creates a post
    //base endpoint /categories/restaurants/location?? (plug in the location from the user FE search)
    //this is just rerouting - no db connections

    //-------- INVITE RESTAURANT SEARCH ---------------------------------------
    // this takes that ripped restaurant ID from selected (plus sign) res in front end and then does a new search for
    // just that res to then store to the DB for an invite
    // use restaurantDAO && inviteDAO (bundle them together)


}

