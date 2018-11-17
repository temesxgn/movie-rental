package com.utdallas.movierental.price;

import java.math.BigDecimal;

public class ChildrensPrice implements Price {

    private static final int EXTENDED_RENT_LENGTH = 3;
    private static final double CHARGE_AMOUNT = 1.5;

    @Override
    public BigDecimal getChargeAmount(int daysRented) {
        double chargeAmount = CHARGE_AMOUNT;
        if (daysRented > EXTENDED_RENT_LENGTH) {
            chargeAmount += (daysRented - EXTENDED_RENT_LENGTH) * CHARGE_AMOUNT;
        }

        return BigDecimal.valueOf(chargeAmount);
    }

}
