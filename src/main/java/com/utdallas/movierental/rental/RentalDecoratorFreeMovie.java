package com.utdallas.movierental.rental;

public class RentalDecoratorFreeMovie extends RentalDecorator {

    public RentalDecoratorFreeMovie(Rental rental) {
        super(rental);
    }

    @Override
    public double getChargeAmount() {
        return 0;
    }

    @Override
    public String toString() {
        return "Free Movie";
    }

}
