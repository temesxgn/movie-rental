package com.utdallas.movierental.frequentRenterPoints;

public abstract class FrequentRenterPointsStrategy implements FrequentRenterPoints {

    @Override
    public int getPoints() {
        return 1;
    }

}
