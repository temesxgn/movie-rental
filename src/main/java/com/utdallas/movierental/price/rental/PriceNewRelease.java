package com.utdallas.movierental.price.rental;

import com.utdallas.movierental.price.Price;

import java.math.BigDecimal;

public class PriceNewRelease implements Price {

    private static final double CHARGE_MULTIPLIER = 3;
    private int daysRented;

    public PriceNewRelease(int daysRented) {
        this.daysRented = daysRented;
    }

    @Override
    public BigDecimal getChargeAmount() {
        return BigDecimal.valueOf(daysRented * CHARGE_MULTIPLIER);
    }

}
