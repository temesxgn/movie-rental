package com.utdallas.movierental.frequentRenterPoints;

public abstract class FrequentRenterPointsStrategy implements FrequentRenterPoints {

    private static final int POINTS = 1;

    @Override
    public int getPoints() {
        return POINTS;
    }

}
