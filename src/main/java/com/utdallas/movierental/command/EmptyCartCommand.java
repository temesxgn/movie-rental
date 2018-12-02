package com.utdallas.movierental.command;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.database.Entry;
import com.utdallas.movierental.service.DatabaseService;
import com.utdallas.movierental.util.ApplicationUtil;

import java.math.BigDecimal;

public class EmptyCartCommand extends BaseCommand {

    private Cart cart;

    public EmptyCartCommand(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.getItems().forEach(item -> DatabaseService.findByTitle(item.getTitle())
                        .ifPresent(entry -> DatabaseService.addAvailabilityAmountForEntry(entry.getId(), BigDecimal.ONE.intValue())));
        cart.clear();
        ApplicationUtil.println("Cart has been emptied.");
    }
}
