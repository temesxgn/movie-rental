package com.utdallas.movierental.cart;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.rental.Rental;

import java.util.List;

public class RegularCart implements Cart {

    private Customer customer;

    public RegularCart(Customer customer) {
        this.customer = customer;
    }

    @Override
    public List<Rental> getItems() {
        return customer.getRentals();
    }

    @Override
    public double getTotalChargeAmount() {
        return customer.getTotalChargeAmount();
    }

    @Override
    public int getTotalFrequentRenterPoints() {
        return customer.getTotalFrequentRenterPoints();
    }

    @Override
    public String getName() {
        return customer.getName();
    }
}
