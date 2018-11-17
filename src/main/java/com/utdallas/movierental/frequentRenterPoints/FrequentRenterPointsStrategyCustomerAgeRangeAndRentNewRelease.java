package com.utdallas.movierental.frequentRenterPoints;

public class FrequentRenterPointsStrategyCustomerAgeRangeAndRentNewRelease extends FrequentRenterPointsStrategyRegularType {

    @Override
    public int getPoints() {
        return Math.multiplyExact(super.getPoints(), 2);
    }
}
