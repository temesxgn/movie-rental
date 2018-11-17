package com.utdallas.movierental.transaction;

import com.utdallas.movierental.rental.Rental;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private String customerId;
    private List<Rental> rentals;
    private BigDecimal totalChargeAmount;
    private int frequentRenterPoints;

    public Order(String customerId, List<Rental> rentals, BigDecimal totalChargeAmount, int frequentRenterPoints) {
        this.customerId = customerId;
        this.rentals = rentals;
        this.totalChargeAmount = totalChargeAmount;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public BigDecimal getTotalChargeAmount() {
        return totalChargeAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}
