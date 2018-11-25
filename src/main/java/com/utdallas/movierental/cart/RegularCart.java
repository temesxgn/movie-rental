package com.utdallas.movierental.cart;

import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.frequentRenterPoints.FrequentRenterPoints;
import com.utdallas.movierental.frequentRenterPoints.customer.FrequentRenterPointsCustomerStrategyFactory;
import com.utdallas.movierental.transaction.Order;
import com.utdallas.movierental.util.NumberUtils;

import java.math.BigDecimal;
import java.util.List;

public class RegularCart implements Cart {

    private Customer customer;
    private List<CheckoutOption> items;

    public RegularCart(Customer customer, List<CheckoutOption> items) {
        this.customer = customer;
        this.items = items;
    }

    @Override
    public List<CheckoutOption> getItems() {
        return items;
    }

    @Override
    public void addItem(CheckoutOption item) {
        this.items.add(item);
    }

    @Override
    public BigDecimal getTotalChargeAmount() {
        return NumberUtils.formatTwoDecimalPlaces(items.stream().map(CheckoutOption::getChargeAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    @Override
    public int getTotalFrequentRenterPoints() {
        FrequentRenterPoints customerFrequentRenterPoints = FrequentRenterPointsCustomerStrategyFactory.getStrategy(customer, items);
        return customerFrequentRenterPoints.getPoints() + items.stream().mapToInt(CheckoutOption::getFrequentRenterPoints).sum();
    }

    @Override
    public Order checkout() {
        return new Order(customer.getCustomerId(), items, getTotalChargeAmount(), getTotalFrequentRenterPoints());
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

}
