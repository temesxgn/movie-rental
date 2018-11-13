package com.utdallas.movierental.cart;

import com.utdallas.movierental.rental.Rental;

import java.text.DecimalFormat;
import java.util.List;

public class CartDecoratorAdditionalItemsDiscount extends CartDecorator {

    private static final int percentage = 80;

    public CartDecoratorAdditionalItemsDiscount(Cart cart) {
        super(cart);
    }

    @Override
    public double getTotalChargeAmount() {
        return Double.parseDouble(new DecimalFormat("#.00").format(cart.getTotalChargeAmount() * (percentage/100.0f)));
    }

    @Override
    public String toString() {
        return "Additional Items";
    }

}
