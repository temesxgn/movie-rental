package com.utdallas.movierental.cart;

import com.utdallas.movierental.rental.Rental;

import java.util.List;

public interface Cart {

    List<Rental> getItems();

    void addItem(Rental rental);

    double getTotalChargeAmount();

    int getTotalFrequentRenterPoints();

    void clear();
}
