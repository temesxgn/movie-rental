package com.utdallas.movierental.frequentRenterPoints.rental;

import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.frequentRenterPoints.*;

public class FrequentRenterPointsRentalStrategyFactory {

    private static final int DAYS_RENTED = 1;

    public static FrequentRenterPoints getStrategy(CategoryType type, int daysRented) {
        FrequentRenterPoints frequentRenterPoints;

        if (type.equals(CategoryType.CHILDRENS)) {
            frequentRenterPoints = new FrequentRenterPointsRentalStrategyChildrensType();
        } else if (type.equals(CategoryType.NEW_RELEASE) && daysRented > DAYS_RENTED) {
            frequentRenterPoints = new FrequentRenterPointsRentalStrategyNewReleaseTypeExtendedRental();
        } else if (type.equals(CategoryType.NEW_RELEASE) && daysRented <= DAYS_RENTED) {
            frequentRenterPoints = new FrequentRenterPointsRentalStrategyNewReleaseType();
        } else {
            frequentRenterPoints = new FrequentRenterPointsRentalStrategyRegularType();
        }

        return frequentRenterPoints;
    }

}
