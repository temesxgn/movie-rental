package com.utdallas.movierental.service;

import com.utdallas.movierental.cart.*;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.domain.Item;
import com.utdallas.movierental.domain.ItemDecoratorRentable;
import com.utdallas.movierental.domain.models.Movie;
import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.checkoutoption.rental.RegularRental;
import com.utdallas.movierental.checkoutoption.rental.Rental;
import com.utdallas.movierental.checkoutoption.rental.RentalDecoratorFreeRental;
import com.utdallas.movierental.statement.StatementUtil;
import com.utdallas.movierental.transaction.Order;
import com.utdallas.movierental.util.ApplicationUtil;

public final class CheckoutService {

    private static final int FREE_RENTAL_FRP_MINIMUM = 10;
    private static final int HALF_OFF_PURCHASE_FRP_MINIMUM = 20;
    private static final int ADDITIONAL_ITEMS_MINIMUM = 3;
    private static final int ADDITIONAL_ITEMS_MAXIMUM = 5;

    public static void checkout(Cart cart) {
        cart = applyDiscountsAndPromotions(cart);
        Order order = cart.checkout();
        cart.getCustomer().addFrequentRenterPoints(order.getFrequentRenterPoints());
        cart.getCustomer().addOrder(order);

        //TODO update statement format
        ApplicationUtil.println(StatementUtil.printCustomerCartStatementAsText(cart));
        cart.clear();
        //ApplicationUtil.println(StatementUtil.printAsXML(customer, cart));
    }

    private static Cart applyDiscountsAndPromotions(Cart cart) {
        /**
         *  TODO How should having multiple promotions/discounts for renting and purchasing be handled and applied? (Maybe have a service to handle their respective logic)
         *  TODO How to handle when an item becomes only purchasable and not rentable?
         */

        Customer customer = cart.getCustomer();

        // Simulates the customer adding another item and setting it as free
        if (customer.getFrequentRenterPoints() >= FREE_RENTAL_FRP_MINIMUM) {
            //TODO ask user if they want to add a free rental
            Movie movie = new Movie("Love & Basketball", CategoryType.NEW_RELEASE);
            Item freeRentItem = new ItemDecoratorRentable(movie);
            Rental freeRental = new RentalDecoratorFreeRental(new RegularRental(customer.getCustomerId(), freeRentItem , 1));
            cart.addItem(freeRental);
            customer.deductFrequentRenterPoints(FREE_RENTAL_FRP_MINIMUM);
        }

        if (customer.getFrequentRenterPoints() >= HALF_OFF_PURCHASE_FRP_MINIMUM) {

        }

        // if a customer rents 3-5 items the price of all additional items that he purchases in the same transaction will be 80% of the original prices.
        if (cart.getItems().size() >= ADDITIONAL_ITEMS_MINIMUM && cart.getItems().size() <= ADDITIONAL_ITEMS_MAXIMUM) {
            cart = CartFactory.applyAdditionalItemsDiscount(cart);
        } else if (cart.getItems().size() > ADDITIONAL_ITEMS_MAXIMUM) { //** if more than 5 items were rented, the price of the item in purchase will be reduced in half. *//*
            cart = CartFactory.applyHalfOffDiscount(cart);
        }

        return cart;
    }
}
