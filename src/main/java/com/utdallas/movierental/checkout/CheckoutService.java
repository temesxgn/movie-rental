package com.utdallas.movierental.checkout;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartFactory;
import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.statement.StatementUtil;

public class CheckoutService {

    public void checkout(Customer customer) {
        Cart cart = applyDiscounts(customer);
        System.out.println(StatementUtil.asXML(cart));
    }

    private Cart applyDiscounts(Customer customer) {
        return CartFactory.getCart(customer);
    }
}
