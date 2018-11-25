package com.utdallas.movierental.command;

import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.util.ApplicationUtil;

public class DisplayCustomerInformationCommand extends BaseCommand {

    private Customer customer;

    public DisplayCustomerInformationCommand(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void execute() {
        ApplicationUtil.println("Customer info");
        ApplicationUtil.println(String.format("Name: %s Age %s", customer.getName(), customer.getAge()));
    }
}
