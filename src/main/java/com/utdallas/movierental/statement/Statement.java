package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecorator;
import com.utdallas.movierental.rental.Rental;

public abstract class Statement {

  protected Cart cart;

  public Statement(Cart cart) {
    this.cart = cart;
  }

  public String printStatement() {
    StringBuilder builder = new StringBuilder();
    builder.append(header());
    cart.getItems().forEach(rental -> builder.append(detail(rental)));
    builder.append(footer());
    return builder.toString();
  }

  protected abstract String detail(Rental rental);

  protected abstract String footer();

  protected abstract String header();
}
