package com.utdallas.movierental.cart;

import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.transaction.Order;

import java.util.List;

public abstract class CartDecorator implements Cart {

    protected Cart cart;

    public CartDecorator(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void addItem(CheckoutOption item) {
        cart.addItem(item);
    }

    @Override
    public void removeItem(CheckoutOption item) {
        cart.removeItem(item);
    }

    @Override
    public List<CheckoutOption> getItems() {
        return cart.getItems();
    }

    @Override
    public int getTotalFrequentCustomerPoints() {
        return cart.getTotalFrequentCustomerPoints();
    }

    @Override
    public Order checkout() {
        return cart.checkout();
    }

    @Override
    public void clear() {
        cart.clear();
    }

    @Override
    public Customer getCustomer() {
        return cart.getCustomer();
    }

}
