package com.utdallas.movierental.frequentRenterPoints;

import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.rental.Rental;

import java.util.List;

public final class FrequentRenterPointsStrategyFactory {

    private FrequentRenterPointsStrategyFactory() {

    }

    public static FrequentRenterPoints newRentalFrequentRenterPointsStrategy(MovieType type, int daysRented) {
        FrequentRenterPoints frequentRenterPoints;

        if (type.equals(MovieType.CHILDRENS)) {
            frequentRenterPoints = new FrequentRenterPointsStrategyChildrensType();
        } else if (type.equals(MovieType.NEW_RELEASE) && daysRented > 1) {
            frequentRenterPoints = new FrequentRenterPointsStrategyNewReleaseTypeDoublePoints();
        } else if (type.equals(MovieType.NEW_RELEASE) && daysRented <= 1) {
            frequentRenterPoints = new FrequentRenterPointsStrategyNewReleaseTypeSinglePoints();
        } else {
            frequentRenterPoints = new FrequentRenterPointsStrategyRegularType();
        }

        return frequentRenterPoints;
    }

    // TODO is this really a factory design pattern or something else?
    public static FrequentRenterPoints newCustomerFrequentRenterPointsStrategy(Customer customer, List<Rental> rentals) {
        FrequentRenterPointsCompositeStrategy strategy = new FrequentRenterPointsCompositeStrategy();
        if (customer.getFrequentRenterPoints() == 0) {
            boolean isCustomerRentingMoreThanTwoTypes = rentals.stream().map(Rental::getMovieType).distinct().count() > 2;
            boolean isWithinAgeRange = customer.getAge() >= 18 && customer.getAge() <= 22;
            boolean isRentingAtLeastOneNewRelease = rentals.stream().anyMatch(rental -> rental.getMovieType().equals(MovieType.NEW_RELEASE));

            if (isCustomerRentingMoreThanTwoTypes) {
                strategy.addStrategy(new FrequentRenterPointsStrategyCustomerMoreThanTwoTypes());
            }

            if (isWithinAgeRange && isRentingAtLeastOneNewRelease) {
                strategy.addStrategy(new FrequentRenterPointsStrategyCustomerAgeRangeAndRentingNewRelease());
            }
        }

        return strategy;
    }
}
