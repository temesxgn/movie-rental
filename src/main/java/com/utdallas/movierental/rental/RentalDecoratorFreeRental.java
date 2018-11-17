package com.utdallas.movierental.rental;

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
    public int getFrequentRenterPoints() {
        return BigDecimal.ZERO.intValue();
    }

    @Override
    public String toString() {
        return "Free Movie";
    }

}
