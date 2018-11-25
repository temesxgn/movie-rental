package com.utdallas.movierental;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartFactory;
import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.command.Command;
import com.utdallas.movierental.command.CommandFactory;
import com.utdallas.movierental.command.CommandFactoryData;
import com.utdallas.movierental.command.CommandType;
import com.utdallas.movierental.customer.Customer;
import com.utdallas.movierental.customer.CustomerBuilder;
import com.utdallas.movierental.exception.InvalidInputTypeException;
import com.utdallas.movierental.util.ApplicationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieRentalApplication {

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        ApplicationUtil.print("Hello! What is your name? Name: ");
        String name = scanner.nextLine();
        ApplicationUtil.print("What is your age? Age: ");

        int age = scanner.nextInt();
        scanner.nextLine();

        Customer customer = new CustomerBuilder(name, age).build();
        List<CheckoutOption> items = new ArrayList<>();
        Cart cart = CartFactory.createCart(customer, items);

        while (true) {
            ApplicationUtil.println("Enter [L]ist, [D]one, [P]urchase, [R]ent, [C]heckout, [E]mpty cart, [O]rder history, [I]nfo");
            try {
                CommandType option = CommandType.findByCode(scanner.nextLine());
                Command command = CommandFactory.getCommand(new CommandFactoryData(option, customer, cart));
                command.execute();
            } catch (InvalidInputTypeException e) {
                ApplicationUtil.println("Invalid input! Please select from the options above.");
            }
        }
    }
}
