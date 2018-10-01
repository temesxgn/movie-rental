package com.utdallas.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private ArrayList<Rental> rentals;
    
    public Customer (String name) {
        this.name = name;
        rentals = new ArrayList<>();
    }
    
    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalChargeAmount() {
        return rentals.stream().mapToDouble(Rental::getChargeAmount).sum();
    }

    public int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }
}