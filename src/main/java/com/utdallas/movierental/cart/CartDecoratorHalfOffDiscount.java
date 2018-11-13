package com.utdallas.movierental.cart;

import com.utdallas.movierental.rental.Rental;

import java.util.List;

public class CartDecoratorHalfOffDiscount extends CartDecorator {

    private static final int percentage = 50;

    public CartDecoratorHalfOffDiscount(Cart cart) {
        super(cart);
    }

    @Override
    public double getTotalChargeAmount() {
        return cart.getTotalChargeAmount() * (percentage/100.0f);
    }

    @Override
    public String toString() {
        return "Half Off";
    }
}
