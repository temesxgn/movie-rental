package com.utdallas.movierental.frequentcustomerpoints;

public abstract class FrequentCustomerPointsStrategy implements FrequentCustomerPoints {

    private static final int POINTS = 1;

    @Override
    public int getPoints() {
        return POINTS;
    }

}
