package com.utdallas.movierental.cart;

import com.utdallas.movierental.rental.Rental;

import java.util.List;

public interface Cart {

    List<Rental> getItems();

    double getTotalChargeAmount();

    int getTotalFrequentRenterPoints();

    String getName();
}
