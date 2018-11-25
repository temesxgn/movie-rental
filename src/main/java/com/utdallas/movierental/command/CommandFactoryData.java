package com.utdallas.movierental.command;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.customer.Customer;

public class CommandFactoryData {

    private CommandType commandType;
    private Cart cart;
    private Customer customer;

    public CommandFactoryData(CommandType commandType, Customer customer, Cart cart) {
        this.commandType = commandType;
        this.customer = customer;
        this.cart = cart;
    }


    public CommandType getCommandType() {
        return commandType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart getCart() {
        return cart;
    }
}
