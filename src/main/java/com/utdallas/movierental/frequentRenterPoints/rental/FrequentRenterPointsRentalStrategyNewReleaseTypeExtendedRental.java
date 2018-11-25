package com.utdallas.movierental.frequentRenterPoints.rental;

public class FrequentRenterPointsRentalStrategyNewReleaseTypeExtendedRental extends FrequentRenterPointsRentalStrategyNewReleaseType {

    private static final int ADDITIONAL_POINTS = 1;

    @Override
    public int getPoints() {
            return super.getPoints() + ADDITIONAL_POINTS;
    }
}
