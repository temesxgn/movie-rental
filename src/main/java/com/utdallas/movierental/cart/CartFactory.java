package com.utdallas.movierental.cart;

import com.utdallas.movierental.cutomer.Customer;

public final class CartFactory {

    private CartFactory() {

    }

    //TODO is this really factory DP?
    public static Cart getCart(Customer customer) {
        Cart cart = new RegularCart(customer);

        // if a customer rents 3-5 items the price of all additional items that he purchases in the same transaction will be 80% of the original prices.
        if (customer.getRentals().size() >= 3 && customer.getRentals().size() <= 5) {
            cart = new CartDecoratorAdditionalItemsDiscount(cart);
        } else if (customer.getRentals().size() > 5) { //** if more than 5 items were rented, the price of the item in purchase will be reduced in half. *//*
            cart = new CartDecoratorHalfOffDiscount(cart);
        }

        return cart;
    }
}
