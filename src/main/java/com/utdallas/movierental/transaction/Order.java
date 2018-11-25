package com.utdallas.movierental.transaction;

import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.util.ApplicationUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Order {

    private String customerId;
    private List<CheckoutOption> items;
    private BigDecimal totalChargeAmount;
    private int frequentRenterPoints;

    public Order(String customerId, List<CheckoutOption> items, BigDecimal totalChargeAmount, int frequentRenterPoints) {
        this.customerId = customerId;
        this.items = items;
        this.totalChargeAmount = totalChargeAmount;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public List<CheckoutOption> getItems() {
        return items;
    }

    public BigDecimal getTotalChargeAmount() {
        return totalChargeAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    @Override
    public String toString() {
        return String.format("%3s %5s %20s %25s %10.2f %25s %10s",
                this.customerId, ApplicationUtil.PIPE,
                this.items.stream().findAny().get().getTitle(),
                ApplicationUtil.PIPE, this.totalChargeAmount, ApplicationUtil.PIPE, this.frequentRenterPoints);
    }
}
