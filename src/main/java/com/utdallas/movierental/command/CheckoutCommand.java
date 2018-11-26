package com.utdallas.movierental.command;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.service.CheckoutService;
import com.utdallas.movierental.util.ApplicationUtil;

public class CheckoutCommand extends BaseCommand {

    private Cart cart;

    public CheckoutCommand(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        ApplicationUtil.println("Checking out...");
        CheckoutService.checkout(cart);
    }
}
