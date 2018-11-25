package com.utdallas.movierental.command;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.database.Entry;
import com.utdallas.movierental.domain.ItemFactory;
import com.utdallas.movierental.service.DatabaseService;
import com.utdallas.movierental.util.ApplicationUtil;

import java.math.BigDecimal;

public class HandleRentItemEventCommand extends BaseCommand {

    private Cart cart;

    public HandleRentItemEventCommand(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        ApplicationUtil.println("Select item number to rent");
        ApplicationUtil.print("Item number: ");
        int id = scanner.nextInt();
        Entry entry = DatabaseService.findById(id);
        if (!entry.isNull()) {
            validateAvailability(entry);
        } else {
            ApplicationUtil.println("Item with id: " + id + " was not found");
        }
    }

    //TODO askUserForRentLengthAndAddToCart should not be here, update later
    private void validateAvailability(Entry entry) {
        if (!isSelectedQuantityAvailable(BigDecimal.ONE.intValue(), entry.getAvailableQuantity())) {
            ApplicationUtil.println(String.format("Error, there are only %s available.", entry.getAvailableQuantity()));
        } else {
            askUserForRentLengthAndAddToCart(entry);
        }
    }

    private void askUserForRentLengthAndAddToCart(Entry entry) {
        ApplicationUtil.print("How many days would you like to rent? Days: ");
        int rentLength = scanner.nextInt();
        ApplicationUtil.println("Rent " + entry.getItem().getTitle() + " for " + rentLength + " days");
        cart.addItem(ItemFactory.createRentalItem(cart.getCustomer(), entry.getItem(), rentLength));
    }

    private boolean isSelectedQuantityAvailable(final int selectedQuantity, final int availableQuantity) {
        return selectedQuantity <= availableQuantity;
    }
}
