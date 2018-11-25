package com.utdallas.movierental.cart;

import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.customer.Customer;

import java.util.List;

public final class CartFactory {

    public static Cart createCart(final Customer customer, final List<CheckoutOption> items) {
        return new RegularCart(customer, items);
    }

    public static Cart applyAdditionalItemsDiscount(final Cart cart) {
        return new CartDecoratorAdditionalItemsDiscount(cart);
    }

    public static Cart applyHalfOffDiscount(final Cart cart) {
        return new CartDecoratorHalfOffDiscount(cart);
    }

}
