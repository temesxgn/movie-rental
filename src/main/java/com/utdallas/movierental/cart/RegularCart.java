package com.utdallas.movierental.cart;

import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPoints;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPointsStrategyFactory;
import com.utdallas.movierental.rental.Rental;
import com.utdallas.movierental.transaction.Order;
import com.utdallas.movierental.util.NumberUtils;

import java.math.BigDecimal;
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
    public BigDecimal getTotalChargeAmount() {
        return NumberUtils.formatTwoDecimalPlaces(rentals.stream().map(Rental::getChargeAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    @Override
    public int getTotalFrequentRenterPoints() {
        FrequentRenterPoints customerFrequentRenterPoints = FrequentRenterPointsStrategyFactory.newCustomerFrequentRenterPointsStrategy(customer, rentals);
        return customerFrequentRenterPoints.getPoints() + rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }

    @Override
    public Order checkout() {
        return new Order(customer.getCustomerId(), rentals, getTotalChargeAmount(), getTotalFrequentRenterPoints());
    }

}
