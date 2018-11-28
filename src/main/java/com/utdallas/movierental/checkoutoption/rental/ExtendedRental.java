package com.utdallas.movierental.checkoutoption.rental;

import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.util.NumberUtils;

import java.math.BigDecimal;

//TODO makes sense to be class instead of decorator since its more static than dynamic
public class ExtendedRental extends RegularRental {

    //TODO update name to be more clear
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
