package com.utdallas.movierental.frequentcustomerpoints.rental;

import com.utdallas.movierental.domain.type.CategoryType;
import com.utdallas.movierental.frequentcustomerpoints.*;

public class FrequentCustomerPointsRentalStrategyFactory {

    private static final int DAYS_RENTED = 3;

    public static FrequentCustomerPoints getStrategy(CategoryType type, int daysRented) {
        FrequentCustomerPoints frequentCustomerPoints;

        if (type.equals(CategoryType.CHILDRENS)) {
            frequentCustomerPoints = new FrequentCustomerPointsRentalStrategyChildrensType();
        } else if (type.equals(CategoryType.NEW_RELEASE) && daysRented > DAYS_RENTED) {
            frequentCustomerPoints = new FrequentCustomerPointsRentalStrategyNewReleaseTypeExtendedRental();
        } else if (type.equals(CategoryType.NEW_RELEASE) && daysRented <= DAYS_RENTED) {
            frequentCustomerPoints = new FrequentCustomerPointsRentalStrategyNewReleaseType();
        } else {
            frequentCustomerPoints = new FrequentCustomerPointsRentalStrategyRegularType();
        }

        return frequentCustomerPoints;
    }

}
