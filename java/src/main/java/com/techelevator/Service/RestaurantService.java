package com.techelevator.Service;

import com.techelevator.Service.DTO.BusinessesDTO;
import com.techelevator.Service.DTO.RestaurantDTO;
import com.techelevator.model.Restaurant;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Component
public class RestaurantService {

    private final String BASE_URL = "https://api.yelp.com/v3";
    private final String API_KEY = "Pitw0I9VsxYc-wHu3Us_WTiMcfSehewIJw-sqDWBDdNdb5-haGIXthYN6oXI1enVAD3a-I0-r0tc1HdttbghiOMjEXDyaZnP7aC9M2lZXNryad-0AQsI0vz-m4-vYXYx";
    private RestTemplate restTemplate = new RestTemplate();

    public RestaurantService() {
    }


    //TODO: refactor into proper type return method ya ya ya
    public List<RestaurantDTO> getAllRestaurants(String location) {

        List<RestaurantDTO> searchResults = new ArrayList<>();

        String restaurantByLocationEndpoint = String.format("/businesses/search?location=%s&categories=restaurants&limit=49&offset=49", location);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + API_KEY);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<BusinessesDTO> response = new RestTemplate().exchange(BASE_URL + restaurantByLocationEndpoint, HttpMethod.GET, request, BusinessesDTO.class);

        //TO TEST
        for (RestaurantDTO rest : response.getBody().getBusinesses()) {
            searchResults.add(rest);
            System.out.println(rest.getLocation().toString());
        }

        return searchResults;
    }


    public RestaurantDTO getRestaurant(String yelpKey) {

        String restaurantByLocationEndpoint = String.format("/businesses/%s", yelpKey);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + API_KEY);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<RestaurantDTO> response = new RestTemplate().exchange(BASE_URL + restaurantByLocationEndpoint, HttpMethod.GET, request, RestaurantDTO.class);

        System.out.println(response.getBody().getName());

        RestaurantDTO likedRestaurants = response.getBody();

        return likedRestaurants;

    }



}






