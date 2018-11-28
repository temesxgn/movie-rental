package com.utdallas.movierental.frequentcustomerpoints.customer;

import com.utdallas.movierental.frequentcustomerpoints.rental.FrequentCustomerPointsRentalStrategyRegularType;

//  computation gives double regular points
public class FrequentCustomerPointsRentalStrategyCustomerRentMoreThanTwoTypes extends FrequentCustomerPointsRentalStrategyRegularType {

    private static final int MULTIPLIER = 2;

    @Override
    public int getPoints() {
        return Math.multiplyExact(super.getPoints(), MULTIPLIER);
    }
}
