package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.checkoutoption.CheckoutOption;
import com.utdallas.movierental.customer.Customer;

public abstract class Statement {

  protected Cart cart;

  public Statement(Cart cart) {
    this.cart = cart;
  }

  public String printStatement() {
    StringBuilder builder = new StringBuilder();
    builder.append(header(cart.getCustomer()));
    cart.getItems().forEach(item -> builder.append(detail(item)));
    builder.append(footer(cart));
    return builder.toString();
  }

  protected abstract String detail(CheckoutOption item);

  protected abstract String footer(Cart cart);

  protected abstract String header(Customer customer);
}
