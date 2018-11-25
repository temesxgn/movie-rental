package com.utdallas.movierental.cart;

import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.transaction.Order;

import java.math.BigDecimal;
import java.util.List;

public interface Cart {

    List<CheckoutOption> getItems();

    void addItem(CheckoutOption item);

    BigDecimal getTotalChargeAmount();

    int getTotalFrequentRenterPoints();

    Order checkout();

    void clear();

    Customer getCustomer();
}
