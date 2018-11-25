package com.utdallas.movierental.command;

import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.util.ApplicationUtil;

public class DisplayOrderHistoryCommand extends BaseCommand {

    private Customer customer;

    public DisplayOrderHistoryCommand(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void execute() {
        ApplicationUtil.println("Order history");
        customer.getOrderHistory().forEach(order -> ApplicationUtil.println(order.toString()));
    }
}
