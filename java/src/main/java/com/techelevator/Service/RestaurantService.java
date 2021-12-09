package com.techelevator.Service;

import com.techelevator.dao.JdbcRestaurantDao;
import com.techelevator.model.Restaurant;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class RestaurantService implements RestaurantServices {

    private final String BASE_URL = "https://api.yelp.com/v3"; ///businesses/search and then append specific parameter based on each get??
    private final String API_KEY = "Pitw0I9VsxYc-wHu3Us_WTiMcfSehewIJw-sqDWBDdNdb5-haGIXthYN6oXI1enVAD3a-I0-r0tc1HdttbghiOMjEXDyaZnP7aC9M2lZXNryad-0AQsI0vz-m4-vYXYx";
    private RestTemplate restTemplate = new RestTemplate();

    public RestaurantService (){}

    //rename this method but this should be the template for other API calls

//    public Restaurant


    public Restaurant getAllRestaurants() {


        String restaurantByLocationEndpoint = "/businesses/search?location=VirginiaBeach&categories=restaurants&limit=49&offset=49";
        //need to adjust this so that parameters are not hard coded (path variable?)

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + API_KEY);
        HttpEntity request = new HttpEntity(headers);


        ResponseEntity<String> response = new RestTemplate().exchange(BASE_URL + restaurantByLocationEndpoint, HttpMethod.GET, request, String.class);
        //getforobject?

        System.out.println(response.getBody());
        //map this to a restaurantDTO object and then put that into a list to send back to the front

        return new Restaurant();
    }


    // can we use the .getBody() object to create a Restaurant object that can then be embedded in an invitation object and then
    // pass that puppy around the whole back end?
    // meaning: use these methods below to "reverse map" JSON object into a java object that we can use.


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


