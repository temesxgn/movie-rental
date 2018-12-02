package com.utdallas.movierental.service;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartFactory;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.statement.StatementUtil;
import com.utdallas.movierental.customer.Order;
import com.utdallas.movierental.util.ApplicationUtil;

public final class CheckoutService {

    private static final int ADDITIONAL_ITEMS_MINIMUM = 3;
    private static final int ADDITIONAL_ITEMS_MAXIMUM = 5;

    public static void checkout(Customer customer, Cart cart) {
        cart = applyDiscountsAndPromotions(cart);
        Order order = cart.checkout();
        customer.addFrequentCustomerPoints(order.getFrequentCustomerPoints());
        customer.addOrder(order);

        //TODO update statement format
        ApplicationUtil.println(StatementUtil.printCustomerCartStatementAsText(cart));
        cart.clear();
    }

    private static Cart applyDiscountsAndPromotions(Cart cart) {
        // if a customer rents 3-5 items the price of all additional items that he purchases in the same transaction will be 80% of the original prices.
        if (cart.getItems().size() >= ADDITIONAL_ITEMS_MINIMUM && cart.getItems().size() <= ADDITIONAL_ITEMS_MAXIMUM) {
            cart = CartFactory.applyAdditionalItemsDiscount(cart);
        } else if (cart.getItems().size() > ADDITIONAL_ITEMS_MAXIMUM) { //** if more than 5 items were rented, the price of the item in purchase will be reduced in half. *//*
            cart = CartFactory.applyHalfOffDiscount(cart);
        }

        return cart;
    }
}
