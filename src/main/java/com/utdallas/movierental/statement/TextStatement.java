package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecorator;
import com.utdallas.movierental.rental.Rental;

public class TextStatement extends Statement {

  public TextStatement(Cart cart) {
    super(cart);
  }

  @Override
  protected String detail(Rental rental) {
    return String.format("\t%s\t%s%n", rental.getMovieTitle(), rental.getChargeAmount());
  }

  @Override
  protected String footer() {
    String footer = String.format("Amount owed is %s.%nYou earned %s frequent renter points",
            cart.getTotalChargeAmount(), cart.getTotalFrequentRenterPoints());

    if (cart instanceof CartDecorator) {
        String discount = cart.toString();
        footer = String.format("%s discount has been applied! %n%s", discount, footer);
    }

    return footer;
  }

  @Override
  protected String header() {
    return String.format("%nRental Record for %s%n", cart.getName());
  }
}
