package com.utdallas.movierental.price;

public class NewReleasePrice implements Price {

    private static final double CHARGE_MULTIPLIER = 3;

    @Override
    public double getChargeAmount(int daysRented) {
        return daysRented * CHARGE_MULTIPLIER;
    }

}
