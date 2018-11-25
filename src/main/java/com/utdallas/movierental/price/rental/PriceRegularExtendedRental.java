package com.utdallas.movierental.price.rental;

import com.utdallas.movierental.price.Price;

import java.math.BigDecimal;

public class PriceRegularExtendedRental implements Price {

    private static final int EXTENDED_RENT_LENGTH = 2;
    private static final double CHARGE_AMOUNT = 2;
    private int daysRented;

    public PriceRegularExtendedRental(int daysRented) {
        this.daysRented = daysRented;
    }

    @Override
    public BigDecimal getChargeAmount() {
        double chargeAmount = CHARGE_AMOUNT + ((daysRented - EXTENDED_RENT_LENGTH) * CHARGE_AMOUNT);
        return BigDecimal.valueOf(chargeAmount);
    }
}
