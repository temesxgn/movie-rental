package com.utdallas.movierental.cart;

import com.utdallas.movierental.rental.Rental;

import java.util.List;

public abstract class CartDecorator implements Cart {

    protected Cart cart;

    public CartDecorator(Cart cart) {
        this.cart = cart;
    }

    @Override
    public List<Rental> getItems() {
        return cart.getItems();
    }

    @Override
    public int getTotalFrequentRenterPoints() {
        return cart.getTotalFrequentRenterPoints();
    }

    @Override
    public String getName() {
        return cart.getName();
    }

}
