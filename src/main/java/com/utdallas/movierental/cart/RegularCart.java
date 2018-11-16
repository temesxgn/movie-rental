package com.utdallas.movierental.cart;

import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPoints;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPointsStrategyFactory;
import com.utdallas.movierental.rental.Rental;

import java.util.List;

public class RegularCart implements Cart {

    private Customer customer;
    private List<Rental> rentals;

    public RegularCart(Customer customer, List<Rental> rentals) {
        this.customer = customer;
        this.rentals = rentals;
    }

    @Override
    public List<Rental> getItems() {
        return rentals;
    }

    @Override
    public void addItem(Rental rental) {
        this.rentals.add(rental);
    }

    @Override
    public double getTotalChargeAmount() {
        return rentals.stream().mapToDouble(Rental::getChargeAmount).sum();
    }

    @Override
    public int getTotalFrequentRenterPoints() {
        FrequentRenterPoints customerFrequentRenterPoints = FrequentRenterPointsStrategyFactory.newCustomerFrequentRenterPointsStrategy(customer, rentals);
        return customerFrequentRenterPoints.getPoints() + rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }

    @Override
    public void clear() {
        this.rentals.clear();
    }
}
