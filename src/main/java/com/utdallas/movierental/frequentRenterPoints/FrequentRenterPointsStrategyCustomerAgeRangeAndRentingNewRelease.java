package com.utdallas.movierental.frequentRenterPoints;

import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPointsStrategyRegularType;

public class FrequentRenterPointsStrategyCustomerAgeRangeAndRentingNewRelease extends FrequentRenterPointsStrategyRegularType {

    @Override
    public int getPoints() {
        return Math.multiplyExact(super.getPoints(), 2);
    }
}
