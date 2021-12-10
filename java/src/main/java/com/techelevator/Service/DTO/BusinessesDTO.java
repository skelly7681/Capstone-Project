package com.techelevator.Service.DTO;

public class BusinessesDTO {

    public RestaurantDTO[] businesses;
    public int total;

    public RestaurantDTO[] getBusinesses() {
        return businesses;
    }

    public void setBusinesses(RestaurantDTO[] businesses) {
        this.businesses = businesses;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
