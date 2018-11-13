package com.utdallas.movierental.promotion;

import com.utdallas.movierental.cutomer.Customer;

public class FreeMovieRentalPromotion implements Promotion {

    private static final int REQUIRED_POINTS = 10;

    @Override
    public boolean canApply(Customer c) {
        return c.getTotalFrequentRenterPoints() > REQUIRED_POINTS;
    }
}
