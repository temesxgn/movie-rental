package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecorator;
import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.rental.Rental;

public abstract class Statement {

  protected Cart cart;
  protected Customer customer;

  public Statement(Customer customer, Cart cart) {
    this.customer = customer;
    this.cart = cart;
  }

  public String printStatement() {
    StringBuilder builder = new StringBuilder();
    builder.append(header(customer));
    cart.getItems().forEach(rental -> builder.append(detail(rental)));
    builder.append(footer(customer, cart));
    return builder.toString();
  }

  protected abstract String detail(Rental rental);

  protected abstract String footer(Customer customer, Cart cart);

  protected abstract String header(Customer customer);
}
