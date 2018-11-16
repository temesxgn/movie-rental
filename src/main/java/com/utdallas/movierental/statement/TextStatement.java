package com.utdallas.movierental.statement;

import com.utdallas.movierental.cart.Cart;
import com.utdallas.movierental.cart.CartDecorator;
import com.utdallas.movierental.cutomer.Customer;
import com.utdallas.movierental.rental.Rental;

public class TextStatement extends Statement {

  public TextStatement(Customer customer, Cart cart) {
    super(customer, cart);
  }

  @Override
  protected String detail(Rental rental) {
    return String.format("\t%s\t%s%n", rental.getMovieTitle(), rental.getChargeAmount());
  }

  @Override
  protected String footer(Customer customer, Cart cart) {
    String footer = String.format("Amount owed is %s.%nYou earned %s frequent renter points. Total frequent renter points: %s",
            cart.getTotalChargeAmount(), cart.getTotalFrequentRenterPoints(), customer.getFrequentRenterPoints());

    if (cart instanceof CartDecorator) {
        String discount = cart.toString();
        footer = String.format("%s discount has been applied! %n%s", discount, footer);
    }

    return footer;
  }

  @Override
  protected String header(Customer customer) {
    return String.format("%nRental Record for %s%n", customer.getName());
  }
}
