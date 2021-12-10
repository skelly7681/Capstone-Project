package com.techelevator.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.techelevator.Service.DTO.BusinessesDTO;
import com.techelevator.Service.DTO.RestaurantDTO;
import com.techelevator.dao.JdbcRestaurantDao;
import com.techelevator.model.Restaurant;
import org.apache.commons.logging.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


@Component
public class RestaurantService implements RestaurantServices {

    private final String BASE_URL = "https://api.yelp.com/v3"; ///businesses/search and then append specific parameter based on each get??
    private final String API_KEY = "Pitw0I9VsxYc-wHu3Us_WTiMcfSehewIJw-sqDWBDdNdb5-haGIXthYN6oXI1enVAD3a-I0-r0tc1HdttbghiOMjEXDyaZnP7aC9M2lZXNryad-0AQsI0vz-m4-vYXYx";
    private RestTemplate restTemplate = new RestTemplate();

    public RestaurantService (){}


    //TODO: refactor into proper type return method ya ya ya
    public Restaurant getAllRestaurants(String location) {

        String restaurantByLocationEndpoint = String.format("/businesses/search?location=%s&categories=restaurants&limit=49&offset=49", location) ;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + API_KEY);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<BusinessesDTO> response = new RestTemplate().exchange(BASE_URL + restaurantByLocationEndpoint, HttpMethod.GET, request, BusinessesDTO.class);


        //TO TEST
        for (RestaurantDTO rest : response.getBody().getBusinesses()) {
            System.out.println(rest.getPrice());
        }

        // THIS RETURNS THE NULL OBJECT
        return new Restaurant();
    }



    public Restaurant getRestaurantId() {
        Restaurant restaurant = restTemplate.getForObject(BASE_URL, Restaurant.class); //this will need to include API-KEY
        return restaurant;
    }

    public Restaurant getRestaurantName(){
        Restaurant restaurantName = restTemplate.getForObject(BASE_URL, Restaurant.class);
        return restaurantName;
    }

    public Restaurant getRestaurantType(){
        Restaurant restaurantType = restTemplate.getForObject(BASE_URL, Restaurant.class);
        return restaurantType;
    }

    public Restaurant getRestaurantAddress(){
        Restaurant restaurantAddress = restTemplate.getForObject(BASE_URL, Restaurant.class);
        return restaurantAddress;
    }

    public Restaurant getOpenTime(){
        Restaurant restaurantOpenTime = restTemplate.getForObject(BASE_URL, Restaurant.class);
        return restaurantOpenTime;
    }

    public Restaurant getCloseTime(){
        Restaurant restaurantCloseTime = restTemplate.getForObject(BASE_URL, Restaurant.class);
        return restaurantCloseTime;
    }

    public Restaurant getPhoneNumber(){
        Restaurant restaurantPhoneNumber = restTemplate.getForObject(BASE_URL, Restaurant.class);
        return restaurantPhoneNumber;
    }

    public Restaurant getThumbnailImage(){
        Restaurant restaurantThumbnailImage = restTemplate.getForObject(BASE_URL, Restaurant.class);
        return restaurantThumbnailImage;
    }

    public Restaurant getStarRating(){
        Restaurant restaurantStarRating = restTemplate.getForObject(BASE_URL, Restaurant.class);
        return restaurantStarRating;
    }

    public Restaurant isTakeOut(){
        Restaurant restaurantIsTakeOut = restTemplate.getForObject(BASE_URL, Restaurant.class);
        return restaurantIsTakeOut;
    }

    public Restaurant isDelivery(){
        Restaurant restaurantIsDelivery = restTemplate.getForObject(BASE_URL, Restaurant.class);
        return restaurantIsDelivery;
    }

//    public Restaurant isVetoed(){
//        Restaurant restaurantIsDelivery = restTemplate.getForObject(BASE_URL, Restaurant.class);
//        return restaurantIsDelivery;
//    }                                 --> would this be here since it is something the user sets?

}



//    public RestaurantService(JdbcRestaurantDao restaurantDao) {
////        this.restaurantDao = restaurantDao;
//    }
//    //where we call the yelp API
//    public Restaurant getRestaurant(){
//        return null;
//    }


