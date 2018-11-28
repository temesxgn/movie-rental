package com.utdallas.movierental.checkoutoption.rental;

import com.utdallas.movierental.domain.type.CategoryType;

import java.math.BigDecimal;

public abstract class RentalDecorator implements Rental  {

    protected Rental rental;

    public RentalDecorator(Rental rental) {
        this.rental = rental;
    }

    @Override
    public int getDaysRented() {
        return this.rental.getDaysRented();
    }

    @Override
    public String getTitle() {
        return this.rental.getTitle();
    }

    @Override
    public CategoryType getCategory() {
        return this.rental.getCategory();
    }

    @Override
    public BigDecimal getChargeAmount() {
        return this.rental.getChargeAmount();
    }

    @Override
    public int getFrequentCustomerPoints() {
        return this.rental.getFrequentCustomerPoints();
    }
}
