package com.utdallas.movierental.cart;

import com.utdallas.movierental.rental.Rental;
import com.utdallas.movierental.transaction.Order;

import java.math.BigDecimal;
import java.util.List;

public interface Cart {

    List<Rental> getItems();

    void addItem(Rental rental);

    BigDecimal getTotalChargeAmount();

    int getTotalFrequentRenterPoints();

    Order checkout();

}
