package com.techelevator.Service.DTO.externalModels;

public class Transactions {

    private boolean hasTakeOut;
    private boolean hasDelivery;

    public boolean isHasTakeOut() {
        return hasTakeOut;
    }

    public void setHasTakeOut(boolean hasTakeOut) {
        this.hasTakeOut = hasTakeOut;
    }

    public boolean isHasDelivery() {
        return hasDelivery;
    }

    public void setHasDelivery(boolean hasDelivery) {
        this.hasDelivery = hasDelivery;
    }

    public Transactions() {
    }
}
