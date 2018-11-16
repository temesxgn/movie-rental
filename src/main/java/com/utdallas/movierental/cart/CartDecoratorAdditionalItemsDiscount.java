package com.utdallas.movierental.cart;

public class CartDecoratorAdditionalItemsDiscount extends CartDecorator {

    private static final int percentage = 80;

    public CartDecoratorAdditionalItemsDiscount(Cart cart) {
        super(cart);
    }

    // TODO Fix format
    @Override
    public double getTotalChargeAmount() {
        return cart.getTotalChargeAmount() * (percentage / 100.0f);
    }

    @Override
    public String toString() {
        return "Additional Items";
    }

}
