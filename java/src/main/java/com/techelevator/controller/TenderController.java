
package com.techelevator.controller;

import com.techelevator.Service.DTO.ExtModels.ApiCategories;
import com.techelevator.Service.DTO.RestaurantDTO;
import com.techelevator.Service.RestaurantService;
import com.techelevator.dao.*;
import com.techelevator.model.Invite;
import com.techelevator.model.LoginDTO;
import com.techelevator.model.Restaurant;
import com.techelevator.model.User;
import com.techelevator.security.jwt.JWTFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
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
    public Restaurant getRestaurantById(@PathVariable int restaurantId) {

        return restaurantDao.getRestaurantById(restaurantId);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/restaurants", method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurantsByInviteId(int inviteId) {

        return restaurantDao.getAllRestaurantsByInviteId(inviteId);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/finalists", method = RequestMethod.GET)
    public List<Restaurant> getFinalistsByInviteId(int inviteId) {

        return restaurantDao.getFinalistsByInviteId(inviteId);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/vetoed", method = RequestMethod.PUT)
    public void thumbsDown(@RequestBody Restaurant restaurant) {

        restaurantDao.thumbsDown(restaurant.getRestaurantId());

    }

    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/restaurants/save", method = RequestMethod.POST)
    public void createRestaurant(@RequestBody RestaurantDTO restaurant) {

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

        restaurantDao.createRestaurant(restaurant.getName(), type, restaurant.getLocation().toString(), restaurant.getDisplayPhoneNumber(),restaurant.getImageUrl(),
                restaurant.getRating(), hasTakeOut, hasDelivery, restaurant.getId());

    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/invites/{inviteId}", method = RequestMethod.GET)
    public Invite getInviteByInviteId(@PathVariable int inviteId) {

        return inviteDao.getInviteByInviteId(inviteId);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/invites", method = RequestMethod.GET)
    public List<Invite> getAllInvitesBySenderId(int senderUserId) {

        return inviteDao.getAllInvitesBySenderId(senderUserId);
    }

    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/invites/create", method = RequestMethod.POST)
    public void createInvite(@RequestBody Invite invite) {

        inviteDao.createInvite(invite.getSenderUserId(), invite.getClosingDate(), invite.getClosingTime(), invite.getUniqueLink());
    }

    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/invites/add/restaurant", method = RequestMethod.POST)
    public void addRestaurantToInvite(int inviteId, int restaurantId) {

        inviteDao.addRestaurantToInvite(inviteId, restaurantId);

    }

    //--------------------THIRD PARTY API!!!!!!!!!!!!!!!!!!!!!!!!!!!------------------------

    // BASIC RESTAURANT SEARCH ---------------------------------------
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public List<RestaurantDTO> searchRestaurants(String searchLocation) {
        return rs.getAllRestaurants("NYC");  /// this is just to test the FE -- search bar is still not working
    }

    // INDIVIDUAL RESTAURANT SEARCH ---------------------------------------
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/restaurant", method = RequestMethod.GET)
    public RestaurantDTO individualRestaurant(String yelpKey) {
        return rs.getRestaurantByYelpKey(yelpKey);

    }

}

