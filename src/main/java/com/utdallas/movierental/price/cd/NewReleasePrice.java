package com.utdallas.movierental.price.cd;

import com.utdallas.movierental.price.Price;

import java.math.BigDecimal;

public class NewReleasePrice implements Price {

    private static final double CHARGE_AMOUNT = 2.5;

    @Override
    public BigDecimal getChargeAmount() {
        return BigDecimal.valueOf(CHARGE_AMOUNT);
    }

}
