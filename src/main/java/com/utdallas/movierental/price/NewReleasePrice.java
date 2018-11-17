package com.utdallas.movierental.price;

import java.math.BigDecimal;

public class NewReleasePrice implements Price {

    private static final double CHARGE_MULTIPLIER = 3;

    @Override
    public BigDecimal getChargeAmount(int daysRented) {
        return BigDecimal.valueOf(daysRented * CHARGE_MULTIPLIER);
    }

}
