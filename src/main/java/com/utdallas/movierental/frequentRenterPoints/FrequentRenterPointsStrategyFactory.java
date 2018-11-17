package com.utdallas.movierental.frequentRenterPoints;

import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.rental.Rental;

import java.util.List;

public final class FrequentRenterPointsStrategyFactory {

    private FrequentRenterPointsStrategyFactory() {

    }

    public static FrequentRenterPoints newRentalFrequentRenterPointsStrategy(CategoryType type, int daysRented) {
        FrequentRenterPoints frequentRenterPoints;

        if (type.equals(CategoryType.CHILDRENS)) {
            frequentRenterPoints = new FrequentRenterPointsStrategyChildrensType();
        } else if (type.equals(CategoryType.NEW_RELEASE) && daysRented > 1) {
            frequentRenterPoints = new FrequentRenterPointsStrategyNewReleaseTypeExtendedRental();
        } else if (type.equals(CategoryType.NEW_RELEASE) && daysRented <= 1) {
            frequentRenterPoints = new FrequentRenterPointsStrategyNewReleaseType();
        } else {
            frequentRenterPoints = new FrequentRenterPointsStrategyRegularType();
        }

        return frequentRenterPoints;
    }

    public static FrequentRenterPoints newCustomerFrequentRenterPointsStrategy(Customer customer, List<Rental> rentals) {
        FrequentRenterPointsCompositeStrategy strategy = new FrequentRenterPointsCompositeStrategy();
        boolean isCustomerRentingMoreThanTwoTypes = rentals.stream().map(Rental::getMovieType).distinct().count() > 2;
        boolean isWithinAgeRange = customer.getAge() >= 18 && customer.getAge() <= 22;
        boolean isRentingAtLeastOneNewRelease = rentals.stream().anyMatch(rental -> rental.getMovieType().equals(CategoryType.NEW_RELEASE));

        if (isCustomerRentingMoreThanTwoTypes) {
            strategy.addStrategy(new FrequentRenterPointsStrategyCustomerRentMoreThanTwoTypes());
        }

        if (isWithinAgeRange && isRentingAtLeastOneNewRelease) {
            strategy.addStrategy(new FrequentRenterPointsStrategyCustomerAgeRangeAndRentNewRelease());
        }

        return strategy;
    }
}
