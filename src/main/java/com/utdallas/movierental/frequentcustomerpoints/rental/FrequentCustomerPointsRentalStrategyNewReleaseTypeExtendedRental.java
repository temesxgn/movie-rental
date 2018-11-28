package com.utdallas.movierental.frequentcustomerpoints.rental;

public class FrequentCustomerPointsRentalStrategyNewReleaseTypeExtendedRental extends FrequentCustomerPointsRentalStrategyNewReleaseType {

    private static final int ADDITIONAL_POINTS = 1;

    @Override
    public int getPoints() {
            return super.getPoints() + ADDITIONAL_POINTS;
    }
}
