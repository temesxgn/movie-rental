package com.utdallas.movierental.cart;

import com.utdallas.movierental.util.NumberUtils;

import java.math.BigDecimal;

public class CartDecoratorAdditionalItemsDiscount extends CartDecorator {

    private static final BigDecimal percentage = BigDecimal.valueOf(80);

    public CartDecoratorAdditionalItemsDiscount(Cart cart) {
        super(cart);
    }

    @Override
    public BigDecimal getTotalChargeAmount() {
        return NumberUtils.getPercentage(cart.getTotalChargeAmount(), percentage);
    }

    @Override
    public String toString() {
        return "Additional Items";
    }

}
