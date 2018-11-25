package com.utdallas.movierental.frequentRenterPoints.rental;

// computation gives double regular points
public class FrequentRenterPointsRentalStrategyCustomerAgeRangeAndRentNewRelease extends FrequentRenterPointsRentalStrategyRegularType {

    private static final int MULTIPLIER = 2;

    @Override
    public int getPoints() {
        return Math.multiplyExact(super.getPoints(), MULTIPLIER);
    }
}
