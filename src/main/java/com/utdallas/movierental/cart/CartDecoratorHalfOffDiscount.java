package com.utdallas.movierental.cart;

import com.utdallas.movierental.util.NumberUtils;

import java.math.BigDecimal;

public class CartDecoratorHalfOffDiscount extends CartDecorator {

    private static final BigDecimal percentage = BigDecimal.valueOf(50);

    public CartDecoratorHalfOffDiscount(Cart cart) {
        super(cart);
    }

    @Override
    public BigDecimal getTotalChargeAmount() {
        return NumberUtils.getPercentage(cart.getTotalChargeAmount(), percentage);
    }

    @Override
    public String toString() {
        return "Half Off";
    }
}
