package com.utdallas.movierental.frequentRenterPoints;

import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPointsStrategyRegularType;
import com.utdallas.movierental.rental.Rental;

public class FrequentRenterPointsStrategyCustomerMoreThanTwoTypes extends FrequentRenterPointsStrategyRegularType {

    @Override
    public int getPoints() {
        return Math.multiplyExact(super.getPoints(), 2);
    }
}
