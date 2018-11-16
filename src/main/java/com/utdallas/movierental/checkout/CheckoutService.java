package com.utdallas.movierental.checkout;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecoratorAdditionalItemsDiscount;
import com.utdallas.movierental.cart.CartDecoratorHalfOffDiscount;
import com.utdallas.movierental.cart.RegularCart;
import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.movie.Movie;
import com.utdallas.movierental.movie.MovieType;
import com.utdallas.movierental.rental.RegularRental;
import com.utdallas.movierental.rental.Rental;
import com.utdallas.movierental.rental.RentalDecoratorFreeMovie;
import com.utdallas.movierental.statement.StatementUtil;

import java.util.ArrayList;

//TODO move all hardcoded values to static variables
public final class CheckoutService {

    public static void checkout(Customer customer, ArrayList<Rental> rentals) {
        // TODO where should this go, find better way to implement
        if (customer.getFrequentRenterPoints() > 10) {
            Rental freeRental = new RentalDecoratorFreeMovie(new RegularRental(new Movie("FreeMovie", MovieType.NEW_RELEASE), 1));
            rentals.add(freeRental);
            customer.deductFrequentRenterPoints(10);
        }

        Cart cart = new RegularCart(customer, rentals);
        cart = applyDiscounts(cart);
        customer.addFrequentRenterPoints(cart.getTotalFrequentRenterPoints());
        System.out.println(StatementUtil.asText(customer, cart));
    }

    private static Cart applyDiscounts(Cart cart) {
        // TODO strategy design here?
        // if a customer rents 3-5 items the price of all additional items that he purchases in the same transaction will be 80% of the original prices.
        if (cart.getItems().size() >= 3 && cart.getItems().size() <= 5) {
            cart = new CartDecoratorAdditionalItemsDiscount(cart);
        } else if (cart.getItems().size() > 5) { //** if more than 5 items were rented, the price of the item in purchase will be reduced in half. *//*
            cart = new CartDecoratorHalfOffDiscount(cart);
        }

        return cart;
    }


}
