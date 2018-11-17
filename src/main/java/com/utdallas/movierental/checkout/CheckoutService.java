package com.utdallas.movierental.checkout;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecoratorAdditionalItemsDiscount;
import com.utdallas.movierental.cart.CartDecoratorHalfOffDiscount;
import com.utdallas.movierental.cart.RegularCart;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.domain.Movie;
import com.utdallas.movierental.domain.CategoryType;
import com.utdallas.movierental.rental.RegularRental;
import com.utdallas.movierental.rental.Rental;
import com.utdallas.movierental.rental.RentalDecoratorFreeRental;
import com.utdallas.movierental.statement.StatementUtil;
import com.utdallas.movierental.transaction.Order;
import java.util.ArrayList;

public final class CheckoutService {

    private static final int FREQUENT_RENTER_POINTS_MINIMUM = 10;
    private static final int ADDITIONAL_ITEMS_MINIMUM = 3;
    private static final int ADDITIONAL_ITEMS_MAXIMUM = 5;

    public static void checkout(Customer customer, ArrayList<Rental> rentals) {
        Cart cart = new RegularCart(customer, rentals);
        cart = applyDiscountsAndPromotions(cart, customer);

        Order order = cart.checkout();
        customer.addFrequentRenterPoints(order.getFrequentRenterPoints());
        customer.addOrder(order);

        System.out.println(StatementUtil.printAsText(customer, cart));
    }

    private static Cart applyDiscountsAndPromotions(Cart cart, Customer customer) {
        if (customer.getFrequentRenterPoints() > FREQUENT_RENTER_POINTS_MINIMUM) {
            Rental freeRental = new RentalDecoratorFreeRental(new RegularRental(customer.getCustomerId(), new Movie("Love & Basketball", CategoryType.NEW_RELEASE), 1));
            cart.addItem(freeRental);
            customer.deductFrequentRenterPoints(FREQUENT_RENTER_POINTS_MINIMUM);
        }

        // if a customer rents 3-5 items the price of all additional items that he purchases in the same transaction will be 80% of the original prices.
        if (cart.getItems().size() >= ADDITIONAL_ITEMS_MINIMUM && cart.getItems().size() <= ADDITIONAL_ITEMS_MAXIMUM) {
            cart = new CartDecoratorAdditionalItemsDiscount(cart);
        } else if (cart.getItems().size() > ADDITIONAL_ITEMS_MAXIMUM) { //** if more than 5 items were rented, the price of the item in purchase will be reduced in half. *//*
            cart = new CartDecoratorHalfOffDiscount(cart);
        }

        return cart;
    }
}
