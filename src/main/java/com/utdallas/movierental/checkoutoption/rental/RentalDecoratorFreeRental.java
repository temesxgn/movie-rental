package com.utdallas.movierental.checkoutoption.rental;

import java.math.BigDecimal;

public class RentalDecoratorFreeRental extends RentalDecorator {

    public RentalDecoratorFreeRental(Rental rental) {
        super(rental);
    }

    @Override
    public BigDecimal getChargeAmount() {
        return BigDecimal.ZERO;
    }

    @Override
    public int getFrequentCustomerPoints() {
        return BigDecimal.ZERO.intValue();
    }

    @Override
    public String toString() {
        return "Free Movie";
    }

}
