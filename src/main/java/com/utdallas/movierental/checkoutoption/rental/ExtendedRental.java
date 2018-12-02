package com.utdallas.movierental.checkoutoption.rental;

import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.util.NumberUtils;

import java.math.BigDecimal;

public class ExtendedRental extends RegularRental {

    private static final int EXTENDED_RENTAL_PERCENTAGE = 95;

    public ExtendedRental(String customerId, Item item, int daysRented) {
        super(customerId, item, daysRented);
        PERCENTAGE = BigDecimal.valueOf(EXTENDED_RENTAL_PERCENTAGE);
    }

    @Override
    public BigDecimal getChargeAmount() {
        return NumberUtils.getPercentage(this.item.getPrice(), PERCENTAGE);
    }
}
