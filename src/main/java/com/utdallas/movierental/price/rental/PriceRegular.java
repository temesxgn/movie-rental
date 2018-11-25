package com.utdallas.movierental.price.rental;

import com.utdallas.movierental.price.Price;

import java.math.BigDecimal;

public class PriceRegular implements Price {

    private static final double CHARGE_AMOUNT = 2;

    @Override
    public BigDecimal getChargeAmount() {
        return BigDecimal.valueOf(CHARGE_AMOUNT);
    }
}
