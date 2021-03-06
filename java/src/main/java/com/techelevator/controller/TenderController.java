
package com.techelevator.controller;

import com.techelevator.Service.DTO.ExtModels.ApiCategories;
import com.techelevator.Service.DTO.ExtModels.InviteIdDTO;
import com.techelevator.Service.DTO.InviteDTO;
import com.techelevator.Service.DTO.RestaurantDTO;
import com.techelevator.Service.RestaurantService;
import com.techelevator.dao.*;
import com.techelevator.model.*;
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

//@PreAuthorize("isAuthenticated()")
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

    //tested & works (postman call)
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path= "/restaurants/{restaurantId}", method = RequestMethod.GET)
    public Restaurant getRestaurantById(@PathVariable int restaurantId) {

        return restaurantDao.getRestaurantById(restaurantId);
    }

    //tested & works (postman call)
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/restaurants/all/{inviteId}", method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurantsByInviteId(@PathVariable int inviteId) {
        return restaurantDao.getAllRestaurantsByInviteId(inviteId);
    }

    //tested & works (postman call)
    @PreAuthorize("hasRole('USER')") // returns an empty array with no objects inside of it
    @RequestMapping(path = "/finalists/{inviteId}", method = RequestMethod.GET)
    public List<Restaurant> getFinalistsByInviteId(@PathVariable int inviteId) {

        return restaurantDao.getFinalistsByInviteId(inviteId);
    }

    //tested & works (postman call)
    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/vetoed", method = RequestMethod.PUT)
    public void thumbsDown(@RequestBody RestaurantInviteDTO restaurantInvite) {

        restaurantDao.thumbsDown(restaurantInvite.getInviteId(), restaurantInvite.getRestaurantId());

    }

    //tested & works (front to back)
    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.CREATED) // this saves a restaurant to the db
    @RequestMapping(path = "/restaurants/save", method = RequestMethod.POST)
    public Restaurant createRestaurant(@RequestBody RestaurantDTO restaurant) {

        int restaurantId = restaurantDao.createRestaurant(restaurant);
        return restaurantDao.getRestaurantById(restaurantId);

    }

    //tested & works (front to back)
    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/invites/{inviteId}", method = RequestMethod.GET)
    public Invite getInviteByInviteId(@PathVariable int inviteId) {

        return inviteDao.getInviteByInviteId(inviteId);
    }

    //tested & works (postman call)
    @PreAuthorize("hasRole('USER')") // this populates the "view invites" page // this cannot be a list
    @RequestMapping(path = "/UserInvites/{senderUserId}", method = RequestMethod.GET)
    public List<Invite> getAllInvitesBySenderId(@PathVariable int senderUserId) {

        return inviteDao.getAllInvitesBySenderId(senderUserId);
    }


    // this returns an invite ID that we can then use on the FE for subsequent calls
    //tested & works (postman call)
    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.CREATED)  // this is what is created when they make an invite, inviteId is returned to us
    @RequestMapping(path = "/invites/create", method = RequestMethod.POST)
    public long createInvite(@RequestBody Invite invite) {

        return inviteDao.createInvite(invite).getInviteId();
    }


    // this needs to bundle creating a restaurant and a link in the db to an invite
    //tested & works (postman call)
    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/invites/add", method = RequestMethod.POST)
    public void addRestaurantToInvite(@RequestBody RestaurantInviteDTO restaurantInviteBundle) {

        inviteDao.addRestaurantToInvite(restaurantInviteBundle);

    }

    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public long getUserId(@RequestBody String username) {

        return userDao.findIdByUsername(username);
    }

    //this is giving me grief
//    @PreAuthorize("permitAll()")
//    @RequestMapping(path = "/invites/{link}", method = RequestMethod.GET)
//    public List<Restaurant> getRestaurantsByInviteId(@PathVariable String link) {
//
//        return restaurantDao.getAllRestaurantsByInviteId(inviteDao.getInviteByUniqueLink(link).getInviteId());
//
//    }

    //--------------------THIRD PARTY API!!!!!!!!!!!!!!!!!!!!!!!!!!!------------------------

    //tested & works (front to back)
    // BASIC RESTAURANT SEARCH ---------------------------------------
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public List<RestaurantDTO> searchRestaurants(@RequestBody String searchLocation) {
        return rs.getAllRestaurants(searchLocation);
    }

    // INDIVIDUAL RESTAURANT SEARCH ---------------------------------------
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(path = "/restaurant", method = RequestMethod.GET)
    public RestaurantDTO individualRestaurant(String yelpKey) {
        return rs.getRestaurantByYelpKey(yelpKey);

    }

}

