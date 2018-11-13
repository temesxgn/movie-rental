package com.utdallas.movierental.frequentRenterPoints;

import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.rental.Rental;

public final class FrequentRenterPointsStrategyFactory {

    private FrequentRenterPointsStrategyFactory() {

    }

    public static FrequentRenterPoints newRentalFrequentRenterPointsStrategy(MovieType type, int daysRented) {
        switch (type) {
            case CHILDRENS:
                return new FrequentRenterPointsStrategyChildrensType();
            case NEW_RELEASE:
                return daysRented > 1 ? new FrequentRenterPointsStrategyNewReleaseTypeDoublePoints() : new FrequentRenterPointsStrategyNewReleaseTypeSinglePoints();
            case REGULAR:
            default:
                return new FrequentRenterPointsStrategyRegularType(); // Return regular strategy as default
        }
    }

    // TODO is this really a factory design pattern or something else?
    public static FrequentRenterPoints newCustomerFrequentRenterPointsStrategy(Customer customer) {
        FrequentRenterPointsCustomerStrategy strategy = new FrequentRenterPointsCustomerStrategy();
        boolean isFirstRentalComputation = customer.getFrequentRenterPoints() == 0;
        if (isFirstRentalComputation) {
            boolean isCustomerRentingMoreThanTwoTypes = customer.getRentals().stream().map(Rental::getMovieType).distinct().count() > 2;
            boolean isWithinAgeRange = customer.getAge() >= 18 && customer.getAge() <= 22;
            boolean isRentingAtLeastOneNewRelease = customer.getRentals().stream().anyMatch(rental -> rental.getMovieType().equals(MovieType.NEW_RELEASE));

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
