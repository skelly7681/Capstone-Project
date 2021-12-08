package com.techelevator.Service;

import com.techelevator.model.Restaurant;

import javax.print.DocFlavor;

public interface RestaurantServices {
    Restaurant getRestaurantId();
    Restaurant getRestaurantName();
    Restaurant getRestaurantType();
    Restaurant getRestaurantAddress();
    Restaurant getOpenTime();
    Restaurant getCloseTime();
    Restaurant getPhoneNumber();
    Restaurant getThumbnailImage();
    Restaurant getStarRating();
    Restaurant isTakeOut();
    Restaurant isDelivery();
    //Restaurant isVetoed();  -- would this be in the API call since it is something the user sets?

}
