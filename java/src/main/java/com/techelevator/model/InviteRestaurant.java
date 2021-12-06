package com.techelevator.model;

public class InviteRestaurant {

    private boolean vetoed;

    public InviteRestaurant(boolean vetoed) {
        this.vetoed = vetoed;
    }

    public boolean isVetoed() {
        return vetoed;
    }

    public void setVetoed(boolean vetoed) {
        this.vetoed = vetoed;
    }
}
