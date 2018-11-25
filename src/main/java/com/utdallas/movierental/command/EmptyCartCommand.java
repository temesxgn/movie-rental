package com.utdallas.movierental.command;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.util.ApplicationUtil;

public class EmptyCartCommand extends BaseCommand {

    private Cart cart;

    public EmptyCartCommand(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.clear();
        ApplicationUtil.println("Cart has been emptied.");
    }
}
